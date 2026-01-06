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
      <el-form-item label="项目名称" prop="projectName">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入项目名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类别" prop="category">
        <el-select
          v-model="queryParams.category"
          placeholder="请选择类别"
          clearable
        >
          <el-option
            v-for="dict in dict.type.awards_category"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="级别" prop="level">
        <el-select
          v-model="queryParams.level"
          placeholder="请选择级别"
          clearable
        >
          <el-option
            v-for="dict in dict.type.award_level"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="等级" prop="grade">
        <el-select
          v-model="queryParams.grade"
          placeholder="请选择等级"
          clearable
        >
          <el-option
            v-for="dict in dict.type.award_grade"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="获奖人员" prop="participants">
        <el-input
          v-model="queryParams.participants"
          placeholder="请输入获奖人员"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审核级别" prop="currentLevel">
        <el-select
          v-model="queryParams.currentLevel"
          placeholder="请选择审核级别"
          clearable
        >
          <el-option
            v-for="dict in dict.type.review_level"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
          @click="handleAdd"
          v-hasPermi="['dc:school_awards:add']"
          >新增</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['dc:school_awards:edit']"
          >修改</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['dc:school_awards:remove']"
          >删除</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['dc:school_awards:export']"
          >导出</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="school_awardsList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="项目id" align="center" prop="id" />
      <el-table-column label="项目名称" align="center" prop="projectName" />
      <el-table-column label="类别" align="center" prop="category">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.awards_category"
            :value="scope.row.category"
          />
        </template>
      </el-table-column>
      <el-table-column label="级别" align="center" prop="level">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.award_level" :value="scope.row.level" />
        </template>
      </el-table-column>
      <el-table-column label="等级" align="center" prop="grade">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.award_grade" :value="scope.row.grade" />
        </template>
      </el-table-column>
      <el-table-column label="授奖单位" align="center" prop="awardUnit" />
      <el-table-column
        label="获奖(授予)日期"
        align="center"
        prop="awardDate"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.awardDate, "{y}-{m}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="获奖人员" align="center" prop="participants" />
      <el-table-column
        label="当前审核级别"
        align="center"
        prop="currentLevel"
      />
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
            @click="handleUpdate(scope.row)"
            v-hasPermi="['dc:school_awards:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['dc:school_awards:remove']"
            >删除</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-check"
            @click="handleSubmit(scope.row)"
            >提交</el-button
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

    <!-- 添加或修改学校获奖（荣誉）情况对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入项目名称" />
        </el-form-item>
        <el-form-item label="类别" prop="category">
          <el-select v-model="form.category" placeholder="请选择类别">
            <el-option
              v-for="dict in dict.type.awards_category"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="级别" prop="level">
          <el-select v-model="form.level" placeholder="请选择级别">
            <el-option
              v-for="dict in dict.type.award_level"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="等级" prop="grade">
          <el-select v-model="form.grade" placeholder="请选择等级">
            <el-option
              v-for="dict in dict.type.award_grade"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="授奖单位" prop="awardUnit">
          <el-input v-model="form.awardUnit" placeholder="请输入授奖单位" />
        </el-form-item>
        <el-form-item label="获奖(授予)日期" prop="awardDate">
          <el-date-picker
            clearable
            v-model="form.awardDate"
            type="month"
            value-format="yyyy-MM"
            placeholder="请选择获奖(授予)日期"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审核级别" prop="current_level">
          <el-select v-model="form.current_level" placeholder="请选择审核级别">
            <el-option
              v-for="dict in dict.type.review_level"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="获奖人员" prop="participants">
          <el-input v-model="form.participants" placeholder="请输入获奖" />
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
import {
  listSchool_awards,
  getSchool_awards,
  delSchool_awards,
  addSchool_awards,
  updateSchool_awards,
} from "@/api/dc/school_awards";
import { submit } from "@/api/dm/review";

export default {
  name: "School_awards",
  dicts: ["award_level", "award_grade", "awards_category", "review_level"],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 学校获奖（荣誉）情况表格数据
      school_awardsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectName: null,
        category: null,
        level: null,
        grade: null,
        awardUnit: null,
        awardDate: null,
        participants: null,
        reporterName: null,
        status: null,
        currentLevel: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        projectName: [
          {
            required: true,
            message: "项目(荣誉)名称(全称)不能为空",
            trigger: "blur",
          },
        ],
        category: [
          { required: true, message: "类别不能为空", trigger: "change" },
        ],
        level: [{ required: true, message: "级别不能为空", trigger: "change" }],
        grade: [{ required: true, message: "等级不能为空", trigger: "change" }],
        awardUnit: [
          { required: true, message: "授奖单位不能为空", trigger: "blur" },
        ],
        awardDate: [
          {
            required: true,
            message: "获奖(授予)日期不能为空",
            trigger: "blur",
          },
        ],
        participants: [
          { required: true, message: "完成人不能为空", trigger: "blur" },
        ],
        reporterName: [
          { required: true, message: "填报人不能为空", trigger: "blur" },
        ],
        createBy: [
          { required: true, message: "创建者不能为空", trigger: "blur" },
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" },
        ],
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询学校获奖（荣誉）情况列表 */
    getList() {
      this.loading = true;
      listSchool_awards(this.queryParams).then((response) => {
        this.school_awardsList = response.rows;
        this.total = response.total;
        this.loading = false;
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
        id: null,
        projectName: null,
        category: null,
        level: null,
        grade: null,
        awardUnit: null,
        awardDate: null,
        participants: null,
        remark: null,
        reporterName: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        status: null,
        currentLevel: null,
      };
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
      this.ids = selection.map((item) => item.id);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学校获奖（荣誉）情况";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getSchool_awards(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学校获奖（荣誉）情况";
      });
    },
    /** 提交按钮 */
    submitForm() {
      console.log(this.form);

      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            updateSchool_awards(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSchool_awards(this.form).then((response) => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal
        .confirm(
          '是否确认删除学校获奖（荣誉）情况编号为"' + ids + '"的数据项？'
        )
        .then(function () {
          return delSchool_awards(ids);
        })
        .then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        })
        .catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download(
        "dc/school_awards/export",
        {
          ...this.queryParams,
        },
        `school_awards_${new Date().getTime()}.xlsx`
      );
    },
    handleSubmit(row) {
      const data = {
        tableName: "dc_school_awards",
        pkValue: row.id,
        comment: "数据提交",
      };
      console.log(data);
      
      this.$confirm("确认要提交数据吗？", "数据提交", {
        confirmButtonText: "提交",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          submit(data).then((response) => {
            if (response.code == 200) {
              this.$modal.msgSuccess("提交成功!");
            } else {
              this.$modal.msgError(`提交失败:${response.msg}!`);
            }
          });
        })
        .catch(() => {
          this.$modal.msgInfo("已经提交");
        });
    },
  },
};
</script>
