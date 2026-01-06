<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <el-form-item label="任务名称" prop="taskName">
        <el-input
          v-model="queryParams.taskName"
          placeholder="请输入任务名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          :disabled="multiple"
          @click="handleBatchAssignTasks"
          v-hasPermi="['dm:task:add']"
          >批量分配</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="taskList"
      @selection-change="handleSelectionChange"
      ref="multipleTable"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="left" prop="taskId" width="300"/>
      <el-table-column label="任务名称" align="left" prop="taskName" width="200" />
      <el-table-column label="已分配的部门" align="center" prop="deptList">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.taskDeptList.length == 0" type="info"
            >未分配</el-tag
          >
          <el-tag
            v-else
            v-for="(taskDept, i) in scope.row.taskDeptList"
            :key="i"
            :type="tagTypes[i % tagTypes.length]"
            >{{ taskDept.deptName }}</el-tag
          >
        </template>
      </el-table-column>
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleAssign(scope.row)"
            v-hasPermi="['dm:task:edit']"
            >任务分配</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改数据采集任务分配表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="任务名称">
          <el-tag
            v-for="(t, i) in ids"
            :key="i"
            :type="tagTypes[i % tagTypes.length]"
            style="display: inline-block"
            >{{ t.taskName }}</el-tag
          >
        </el-form-item>
        <el-form-item label="部门名称" prop="tableName">
          <!-- <el-input v-model="form.tableName" placeholder="请输入对应表名" /> -->
          <el-select v-model="form.deptIds" filterable multiple>
            <el-option
              v-for="(dept, index) in deptList"
              :key="index"
              :label="dept.deptName"
              :value="dept.deptId"
            />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTask, getTask, delTask, addTask, updateTask } from "@/api/dm/task";
import { listDept } from "@/api/system/dept";
import { batchAdd } from "@/api/dm/taskdept";
export default {
  name: "Task",
  data() {
    return {
      // tag类型
      tagTypes: ["primary", "success", "warning", "danger"],
      // 部门id
      deptIds: [],
      // 部门列表
      deptList: [],
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedDmTaskDept: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 数据采集任务分配表表格数据
      taskList: [],
      // 任务明细表格数据
      dmTaskDeptList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        taskName: null,
        tableName: null,
        description: null,
        collectionType: null,
        collectionCycle: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        taskName: [
          { required: true, message: "任务名称不能为空", trigger: "blur" },
        ],
      },
    };
  },
  created() {
    this.getList();
    this.getDeptList();
  },
  methods: {
    /** 查询数据采集任务分配表列表 */
    getList() {
      this.loading = true;
      listTask(this.queryParams).then((response) => {
        this.taskList = response.rows;
        console.log(this.taskList);
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 获取部门信息 */
    getDeptList() {
      this.loading = true;
      listDept(this.queryParams).then((response) => {
        this.deptList = response.data;
        // this.total = response.total;
        this.loading = false;
        console.log(this.deptList);
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        taskId: null,
        taskName: null,
        tableName: null,
        description: null,
        collectionType: null,
        collectionCycle: null,
        status: null,
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        deptIds: [],
      };
      this.dmTaskDeptList = [];
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => {
        return {
          taskId: item.taskId,
          taskName: item.taskName,
        };
      });
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    handleBatchAssignTasks() {
      this.reset();
      this.open = true;
      this.title = "批量数据采集任务分配";
      console.log(this.ids);
    },

    handleAssign(row) {
      this.reset();
      this.$refs.multipleTable.clearSelection();
      this.$refs.multipleTable.toggleRowSelection(row);
      // const taskId = row.taskId || this.ids;
      // getTask(taskId).then((response) => {
      //   this.form = response.data;
      //   this.open = true;
      //   this.title = "修改数据采集任务分配表";
      // });
      this.form = row;
      this.open = true;
      this.$set(
        this.form,
        "deptIds",
        (row.taskDeptList || []).map((item) => item.deptId)
      );
      this.ids = [{ taskId: row.taskId, taskName: row.taskName }];
      this.title = "修改数据采集任务分配表";
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          // this.form.dmTaskDeptList = this.dmTaskDeptList;
          // if (this.form.taskId != null) {
          //   updateTask(this.form).then((response) => {
          //     this.$modal.msgSuccess("修改成功");
          //     this.open = false;
          //     this.getList();
          //   });
          // } else {
          //   addTask(this.form).then((response) => {
          //     this.$modal.msgSuccess("新增成功");
          //     this.open = false;
          //     this.getList();
          //   });
          // }
          console.log("=======taskId=======", this.form.deptIds);
          const taskIdsdeptIds = {
            taskIds: this.ids.map((item) => item.taskId),
            deptIds: this.form.deptIds,
          };
          console.log("=======taskIdsdeptIds=======", taskIdsdeptIds);
          batchAdd(taskIdsdeptIds).then((response) => {
            console.log("=======response=======", response);
            if (response.code == 200) {
              this.$modal.msgSuccess("任务分配成功");
              this.open = false;
              this.$refs.multipleTable.clearSelection();
              this.ids = [];
              this.getList();
            }
          });
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const taskIds = row.taskId || this.ids;
      this.$modal
        .confirm(
          '是否确认删除数据采集任务分配表编号为"' + taskIds + '"的数据项？'
        )
        .then(function () {
          return delTask(taskIds);
        })
        .then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        })
        .catch(() => {});
    },
    /** 任务明细序号 */
    rowDmTaskDeptIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 任务明细添加按钮操作 */
    handleAddDmTaskDept() {
      let obj = {};
      obj.deptId = "";
      obj.assignedUser = "";
      obj.assignedDate = "";
      obj.dueDate = "";
      obj.priority = "";
      obj.progress = "";
      obj.detailStatus = "";
      obj.completionDate = "";
      obj.completionNote = "";
      obj.remark = "";
      this.dmTaskDeptList.push(obj);
    },
    /** 任务明细删除按钮操作 */
    handleDeleteDmTaskDept() {
      if (this.checkedDmTaskDept.length == 0) {
        this.$modal.msgError("请先选择要删除的任务明细数据");
      } else {
        const dmTaskDeptList = this.dmTaskDeptList;
        const checkedDmTaskDept = this.checkedDmTaskDept;
        this.dmTaskDeptList = dmTaskDeptList.filter(function (item) {
          return checkedDmTaskDept.indexOf(item.index) == -1;
        });
      }
    },
    /** 复选框选中数据 */
    handleDmTaskDeptSelectionChange(selection) {
      this.checkedDmTaskDept = selection.map((item) => item.index);
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download(
        "dm/task/export",
        {
          ...this.queryParams,
        },
        `task_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
