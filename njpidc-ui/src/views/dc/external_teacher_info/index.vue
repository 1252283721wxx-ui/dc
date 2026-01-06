<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="院系部名称" prop="departmentName">
        <el-input
          v-model="queryParams.departmentName"
          placeholder="请输入院系部名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="编" prop="staffNo">
        <el-input
          v-model="queryParams.staffNo"
          placeholder="请输入编"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出生日期" prop="birthday">
        <el-date-picker clearable
          v-model="queryParams.birthday"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择出生日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="民族" prop="nation">
        <el-input
          v-model="queryParams.nation"
          placeholder="请输入民族"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学历" prop="education">
        <el-input
          v-model="queryParams.education"
          placeholder="请输入学历"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学位" prop="degree">
        <el-input
          v-model="queryParams.degree"
          placeholder="请输入学位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="职务" prop="position">
        <el-input
          v-model="queryParams.position"
          placeholder="请输入职务"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工作单位名称(全称)" prop="workUnit">
        <el-input
          v-model="queryParams.workUnit"
          placeholder="请输入工作单位名称(全称)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="参加工作日期" prop="workStartDate">
        <el-input
          v-model="queryParams.workStartDate"
          placeholder="请输入参加工作日期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="人才项目级别" prop="talentLevel">
        <el-input
          v-model="queryParams.talentLevel"
          placeholder="请输入人才项目级别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="人才项目称号" prop="talentTitle">
        <el-input
          v-model="queryParams.talentTitle"
          placeholder="请输入人才项目称号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="职务等级" prop="professionalRank">
        <el-input
          v-model="queryParams.professionalRank"
          placeholder="请输入职务等级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专业技术职务名称(最高)" prop="professionalTitle">
        <el-input
          v-model="queryParams.professionalTitle"
          placeholder="请输入专业技术职务名称(最高)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发证单位" prop="professionalCertOrg">
        <el-input
          v-model="queryParams.professionalCertOrg"
          placeholder="请输入发证单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="获取日期" prop="professionalCertDate">
        <el-input
          v-model="queryParams.professionalCertDate"
          placeholder="请输入获取日期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="证书等级" prop="certLevel">
        <el-input
          v-model="queryParams.certLevel"
          placeholder="请输入证书等级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="证书名称(最高)" prop="certName">
        <el-input
          v-model="queryParams.certName"
          placeholder="请输入证书名称(最高)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发证单位" prop="certOrg">
        <el-input
          v-model="queryParams.certOrg"
          placeholder="请输入发证单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="获取日期" prop="certDate">
        <el-input
          v-model="queryParams.certDate"
          placeholder="请输入获取日期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="行政所属专业名称" prop="adminMajorName">
        <el-input
          v-model="queryParams.adminMajorName"
          placeholder="请输入行政所属专业名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="行政所属专业代码" prop="adminMajorCode">
        <el-input
          v-model="queryParams.adminMajorCode"
          placeholder="请输入行政所属专业代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="行政所属专业层次" prop="adminMajorLevel">
        <el-input
          v-model="queryParams.adminMajorLevel"
          placeholder="请输入行政所属专业层次"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="行政所属专业大类" prop="adminMajorCategory">
        <el-input
          v-model="queryParams.adminMajorCategory"
          placeholder="请输入行政所属专业大类"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是，担任年限" prop="leaderYears">
        <el-input
          v-model="queryParams.leaderYears"
          placeholder="请输入是，担任年限"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="填报人" prop="reporterName">
        <el-input
          v-model="queryParams.reporterName"
          placeholder="请输入填报人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="当前审核级别" prop="currentLevel">
        <el-input
          v-model="queryParams.currentLevel"
          placeholder="请输入当前审核级别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
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
          v-hasPermi="['dc:external_teacher_info:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['dc:external_teacher_info:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['dc:external_teacher_info:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['dc:external_teacher_info:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="external_teacher_infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="自增主键" align="center" prop="id" />
      <el-table-column label="院系部名称" align="center" prop="departmentName" />
      <el-table-column label="编" align="center" prop="staffNo" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="性别" align="center" prop="gender" />
      <el-table-column label="出生日期" align="center" prop="birthday" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="政治面貌" align="center" prop="politicalStatus" />
      <el-table-column label="民族" align="center" prop="nation" />
      <el-table-column label="学历" align="center" prop="education" />
      <el-table-column label="学位" align="center" prop="degree" />
      <el-table-column label="职务" align="center" prop="position" />
      <el-table-column label="人员类别" align="center" prop="staffType" />
      <el-table-column label="工作单位名称(全称)" align="center" prop="workUnit" />
      <el-table-column label="参加工作日期" align="center" prop="workStartDate" />
      <el-table-column label="人才项目级别" align="center" prop="talentLevel" />
      <el-table-column label="人才项目称号" align="center" prop="talentTitle" />
      <el-table-column label="签约情况" align="center" prop="signStatus" />
      <el-table-column label="职务等级" align="center" prop="professionalRank" />
      <el-table-column label="专业技术职务名称(最高)" align="center" prop="professionalTitle" />
      <el-table-column label="发证单位" align="center" prop="professionalCertOrg" />
      <el-table-column label="获取日期" align="center" prop="professionalCertDate" />
      <el-table-column label="证书等级" align="center" prop="certLevel" />
      <el-table-column label="证书名称(最高)" align="center" prop="certName" />
      <el-table-column label="发证单位" align="center" prop="certOrg" />
      <el-table-column label="获取日期" align="center" prop="certDate" />
      <el-table-column label="是否有行政所属专业" align="center" prop="hasAdminMajor" />
      <el-table-column label="行政所属专业名称" align="center" prop="adminMajorName" />
      <el-table-column label="行政所属专业代码" align="center" prop="adminMajorCode" />
      <el-table-column label="行政所属专业层次" align="center" prop="adminMajorLevel" />
      <el-table-column label="行政所属专业大类" align="center" prop="adminMajorCategory" />
      <el-table-column label="是否专业带头人" align="center" prop="isMajorLeader" />
      <el-table-column label="是，担任年限" align="center" prop="leaderYears" />
      <el-table-column label="填报人" align="center" prop="reporterName" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="当前审核级别" align="center" prop="currentLevel" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['dc:external_teacher_info:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['dc:external_teacher_info:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改1.4.2_校外教师基本情况对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="院系部名称" prop="departmentName">
          <el-input v-model="form.departmentName" placeholder="请输入院系部名称" />
        </el-form-item>
        <el-form-item label="编" prop="staffNo">
          <el-input v-model="form.staffNo" placeholder="请输入编" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="出生日期" prop="birthday">
          <el-date-picker clearable
            v-model="form.birthday"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="民族" prop="nation">
          <el-input v-model="form.nation" placeholder="请输入民族" />
        </el-form-item>
        <el-form-item label="学历" prop="education">
          <el-input v-model="form.education" placeholder="请输入学历" />
        </el-form-item>
        <el-form-item label="学位" prop="degree">
          <el-input v-model="form.degree" placeholder="请输入学位" />
        </el-form-item>
        <el-form-item label="职务" prop="position">
          <el-input v-model="form.position" placeholder="请输入职务" />
        </el-form-item>
        <el-form-item label="工作单位名称(全称)" prop="workUnit">
          <el-input v-model="form.workUnit" placeholder="请输入工作单位名称(全称)" />
        </el-form-item>
        <el-form-item label="参加工作日期" prop="workStartDate">
          <el-input v-model="form.workStartDate" placeholder="请输入参加工作日期" />
        </el-form-item>
        <el-form-item label="人才项目级别" prop="talentLevel">
          <el-input v-model="form.talentLevel" placeholder="请输入人才项目级别" />
        </el-form-item>
        <el-form-item label="人才项目称号" prop="talentTitle">
          <el-input v-model="form.talentTitle" placeholder="请输入人才项目称号" />
        </el-form-item>
        <el-form-item label="职务等级" prop="professionalRank">
          <el-input v-model="form.professionalRank" placeholder="请输入职务等级" />
        </el-form-item>
        <el-form-item label="专业技术职务名称(最高)" prop="professionalTitle">
          <el-input v-model="form.professionalTitle" placeholder="请输入专业技术职务名称(最高)" />
        </el-form-item>
        <el-form-item label="发证单位" prop="professionalCertOrg">
          <el-input v-model="form.professionalCertOrg" placeholder="请输入发证单位" />
        </el-form-item>
        <el-form-item label="获取日期" prop="professionalCertDate">
          <el-input v-model="form.professionalCertDate" placeholder="请输入获取日期" />
        </el-form-item>
        <el-form-item label="证书等级" prop="certLevel">
          <el-input v-model="form.certLevel" placeholder="请输入证书等级" />
        </el-form-item>
        <el-form-item label="证书名称(最高)" prop="certName">
          <el-input v-model="form.certName" placeholder="请输入证书名称(最高)" />
        </el-form-item>
        <el-form-item label="发证单位" prop="certOrg">
          <el-input v-model="form.certOrg" placeholder="请输入发证单位" />
        </el-form-item>
        <el-form-item label="获取日期" prop="certDate">
          <el-input v-model="form.certDate" placeholder="请输入获取日期" />
        </el-form-item>
        <el-form-item label="行政所属专业名称" prop="adminMajorName">
          <el-input v-model="form.adminMajorName" placeholder="请输入行政所属专业名称" />
        </el-form-item>
        <el-form-item label="行政所属专业代码" prop="adminMajorCode">
          <el-input v-model="form.adminMajorCode" placeholder="请输入行政所属专业代码" />
        </el-form-item>
        <el-form-item label="行政所属专业层次" prop="adminMajorLevel">
          <el-input v-model="form.adminMajorLevel" placeholder="请输入行政所属专业层次" />
        </el-form-item>
        <el-form-item label="行政所属专业大类" prop="adminMajorCategory">
          <el-input v-model="form.adminMajorCategory" placeholder="请输入行政所属专业大类" />
        </el-form-item>
        <el-form-item label="是，担任年限" prop="leaderYears">
          <el-input v-model="form.leaderYears" placeholder="请输入是，担任年限" />
        </el-form-item>
        <el-form-item label="填报人" prop="reporterName">
          <el-input v-model="form.reporterName" placeholder="请输入填报人" />
        </el-form-item>
        <el-form-item label="当前审核级别" prop="currentLevel">
          <el-input v-model="form.currentLevel" placeholder="请输入当前审核级别" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
import { listExternal_teacher_info, getExternal_teacher_info, delExternal_teacher_info, addExternal_teacher_info, updateExternal_teacher_info } from "@/api/dc/external_teacher_info"

export default {
  name: "External_teacher_info",
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
      // 1.4.2_校外教师基本情况表格数据
      external_teacher_infoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        departmentName: null,
        staffNo: null,
        name: null,
        gender: null,
        birthday: null,
        politicalStatus: null,
        nation: null,
        education: null,
        degree: null,
        position: null,
        staffType: null,
        workUnit: null,
        workStartDate: null,
        talentLevel: null,
        talentTitle: null,
        signStatus: null,
        professionalRank: null,
        professionalTitle: null,
        professionalCertOrg: null,
        professionalCertDate: null,
        certLevel: null,
        certName: null,
        certOrg: null,
        certDate: null,
        hasAdminMajor: null,
        adminMajorName: null,
        adminMajorCode: null,
        adminMajorLevel: null,
        adminMajorCategory: null,
        isMajorLeader: null,
        leaderYears: null,
        reporterName: null,
        status: null,
        currentLevel: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        departmentName: [
          { required: true, message: "院系部名称不能为空", trigger: "blur" }
        ],
        staffNo: [
          { required: true, message: "编不能为空", trigger: "blur" }
        ],
        name: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
        gender: [
          { required: true, message: "性别不能为空", trigger: "blur" }
        ],
        birthday: [
          { required: true, message: "出生日期不能为空", trigger: "blur" }
        ],
        politicalStatus: [
          { required: true, message: "政治面貌不能为空", trigger: "change" }
        ],
        nation: [
          { required: true, message: "民族不能为空", trigger: "blur" }
        ],
        education: [
          { required: true, message: "学历不能为空", trigger: "blur" }
        ],
        degree: [
          { required: true, message: "学位不能为空", trigger: "blur" }
        ],
        staffType: [
          { required: true, message: "人员类别不能为空", trigger: "change" }
        ],
        workUnit: [
          { required: true, message: "工作单位名称(全称)不能为空", trigger: "blur" }
        ],
        workStartDate: [
          { required: true, message: "参加工作日期不能为空", trigger: "blur" }
        ],
        hasAdminMajor: [
          { required: true, message: "是否有行政所属专业不能为空", trigger: "blur" }
        ],
        isMajorLeader: [
          { required: true, message: "是否专业带头人不能为空", trigger: "blur" }
        ],
        reporterName: [
          { required: true, message: "填报人不能为空", trigger: "blur" }
        ],
        createBy: [
          { required: true, message: "创建者不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询1.4.2_校外教师基本情况列表 */
    getList() {
      this.loading = true
      listExternal_teacher_info(this.queryParams).then(response => {
        this.external_teacher_infoList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        departmentName: null,
        staffNo: null,
        name: null,
        gender: null,
        birthday: null,
        politicalStatus: null,
        nation: null,
        education: null,
        degree: null,
        position: null,
        staffType: null,
        workUnit: null,
        workStartDate: null,
        talentLevel: null,
        talentTitle: null,
        signStatus: null,
        professionalRank: null,
        professionalTitle: null,
        professionalCertOrg: null,
        professionalCertDate: null,
        certLevel: null,
        certName: null,
        certOrg: null,
        certDate: null,
        hasAdminMajor: null,
        adminMajorName: null,
        adminMajorCode: null,
        adminMajorLevel: null,
        adminMajorCategory: null,
        isMajorLeader: null,
        leaderYears: null,
        reporterName: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        status: null,
        currentLevel: null,
        remark: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加1.4.2_校外教师基本情况"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getExternal_teacher_info(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改1.4.2_校外教师基本情况"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateExternal_teacher_info(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addExternal_teacher_info(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids
      this.$modal.confirm('是否确认删除1.4.2_校外教师基本情况编号为"' + ids + '"的数据项？').then(function() {
        return delExternal_teacher_info(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('dc/external_teacher_info/export', {
        ...this.queryParams
      }, `external_teacher_info_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
