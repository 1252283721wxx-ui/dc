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
      <el-form-item label="教工号" prop="staffNo">
        <el-input
          v-model="queryParams.staffNo"
          placeholder="请输入教工号"
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
      <el-form-item label="身份证号" prop="idNumber">
        <el-input
          v-model="queryParams.idNumber"
          placeholder="请输入身份证号"
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
      <el-form-item label="所任职务" prop="position">
        <el-input
          v-model="queryParams.position"
          placeholder="请输入所任职务"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专业领域" prop="majorField">
        <el-input
          v-model="queryParams.majorField"
          placeholder="请输入专业领域"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专业特长" prop="specialty">
        <el-input
          v-model="queryParams.specialty"
          placeholder="请输入专业特长"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="高校教师资格证书发证单位" prop="teacherCertOrg">
        <el-input
          v-model="queryParams.teacherCertOrg"
          placeholder="请输入高校教师资格证书发证单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="高校教师资格证书获取日期" prop="teacherCertDate">
        <el-input
          v-model="queryParams.teacherCertDate"
          placeholder="请输入高校教师资格证书获取日期"
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
      <el-form-item label="专业技术职务发证单位" prop="professionalCertOrg">
        <el-input
          v-model="queryParams.professionalCertOrg"
          placeholder="请输入专业技术职务发证单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专业技术职务获取日期" prop="professionalCertDate">
        <el-input
          v-model="queryParams.professionalCertDate"
          placeholder="请输入专业技术职务获取日期"
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
      <el-form-item label="职业资格证书名称(最高)" prop="certName">
        <el-input
          v-model="queryParams.certName"
          placeholder="请输入职业资格证书名称(最高)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="职业资格证书发证单位" prop="certOrg">
        <el-input
          v-model="queryParams.certOrg"
          placeholder="请输入职业资格证书发证单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="职业资格证书获取日期" prop="certDate">
        <el-input
          v-model="queryParams.certDate"
          placeholder="请输入职业资格证书获取日期"
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
      <el-form-item label="所任公共课程" prop="publicCourseName">
        <el-input
          v-model="queryParams.publicCourseName"
          placeholder="请输入所任公共课程"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是，担任年限" prop="majorLeaderYears">
        <el-input
          v-model="queryParams.majorLeaderYears"
          placeholder="请输入是，担任年限"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是，年限" prop="majorGroupLeaderYears">
        <el-input
          v-model="queryParams.majorGroupLeaderYears"
          placeholder="请输入是，年限"
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
          v-hasPermi="['dc:school_teacher_info:add']"
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
          v-hasPermi="['dc:school_teacher_info:edit']"
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
          v-hasPermi="['dc:school_teacher_info:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['dc:school_teacher_info:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="school_teacher_infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="自增主键" align="center" prop="id" />
      <el-table-column label="院系部名称" align="center" prop="departmentName" />
      <el-table-column label="教工号" align="center" prop="staffNo" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="性别" align="center" prop="gender" />
      <el-table-column label="身份证号" align="center" prop="idNumber" />
      <el-table-column label="出生日期" align="center" prop="birthday" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="政治面貌" align="center" prop="politicalStatus" />
      <el-table-column label="民族" align="center" prop="nation" />
      <el-table-column label="学历" align="center" prop="education" />
      <el-table-column label="学位" align="center" prop="degree" />
      <el-table-column label="人员类别" align="center" prop="staffType" />
      <el-table-column label="所任职务" align="center" prop="position" />
      <el-table-column label="专业领域" align="center" prop="majorField" />
      <el-table-column label="专业特长" align="center" prop="specialty" />
      <el-table-column label="是否拥有高校教师资格证书" align="center" prop="hasTeacherCert" />
      <el-table-column label="高校教师资格证书发证单位" align="center" prop="teacherCertOrg" />
      <el-table-column label="高校教师资格证书获取日期" align="center" prop="teacherCertDate" />
      <el-table-column label="职务等级" align="center" prop="professionalRank" />
      <el-table-column label="专业技术职务名称(最高)" align="center" prop="professionalTitle" />
      <el-table-column label="专业技术职务发证单位" align="center" prop="professionalCertOrg" />
      <el-table-column label="专业技术职务获取日期" align="center" prop="professionalCertDate" />
      <el-table-column label="证书等级" align="center" prop="certLevel" />
      <el-table-column label="职业资格证书名称(最高)" align="center" prop="certName" />
      <el-table-column label="职业资格证书发证单位" align="center" prop="certOrg" />
      <el-table-column label="职业资格证书获取日期" align="center" prop="certDate" />
      <el-table-column label="是否专业教师" align="center" prop="isMajorTeacher" />
      <el-table-column label="行政所属专业名称" align="center" prop="adminMajorName" />
      <el-table-column label="行政所属专业代码" align="center" prop="adminMajorCode" />
      <el-table-column label="行政所属专业层次" align="center" prop="adminMajorLevel" />
      <el-table-column label="行政所属专业大类" align="center" prop="adminMajorCategory" />
      <el-table-column label="是否公共课教师" align="center" prop="isPublicCourseTeacher" />
      <el-table-column label="所任公共课程" align="center" prop="publicCourseName" />
      <el-table-column label="是否为双师型教师" align="center" prop="doubleQualification" />
      <el-table-column label="教学名师" align="center" prop="teachingMaster" />
      <el-table-column label="是否专职思政课教师" align="center" prop="isFulltimeIdeological" />
      <el-table-column label="是否兼职思政课教师" align="center" prop="isParttimeIdeological" />
      <el-table-column label="是否专职辅导员" align="center" prop="isFulltimeCounselor" />
      <el-table-column label="是否兼职辅导员" align="center" prop="isParttimeCounselor" />
      <el-table-column label="是否专职心理健康教师" align="center" prop="isFulltimePsychology" />
      <el-table-column label="是否兼职心理健康教师" align="center" prop="isParttimePsychology" />
      <el-table-column label="是否专业带头人" align="center" prop="isMajorLeader" />
      <el-table-column label="是，担任年限" align="center" prop="majorLeaderYears" />
      <el-table-column label="是否专业" align="center" prop="majorGroupLeader" />
      <el-table-column label="是，年限" align="center" prop="majorGroupLeaderYears" />
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
            v-hasPermi="['dc:school_teacher_info:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['dc:school_teacher_info:remove']"
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

    <!-- 添加或修改1.4.1_校内教师基本信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="院系部名称" prop="departmentName">
          <el-input v-model="form.departmentName" placeholder="请输入院系部名称" />
        </el-form-item>
        <el-form-item label="教工号" prop="staffNo">
          <el-input v-model="form.staffNo" placeholder="请输入教工号" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="身份证号" prop="idNumber">
          <el-input v-model="form.idNumber" placeholder="请输入身份证号" />
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
        <el-form-item label="所任职务" prop="position">
          <el-input v-model="form.position" placeholder="请输入所任职务" />
        </el-form-item>
        <el-form-item label="专业领域" prop="majorField">
          <el-input v-model="form.majorField" placeholder="请输入专业领域" />
        </el-form-item>
        <el-form-item label="专业特长" prop="specialty">
          <el-input v-model="form.specialty" placeholder="请输入专业特长" />
        </el-form-item>
        <el-form-item label="高校教师资格证书发证单位" prop="teacherCertOrg">
          <el-input v-model="form.teacherCertOrg" placeholder="请输入高校教师资格证书发证单位" />
        </el-form-item>
        <el-form-item label="高校教师资格证书获取日期" prop="teacherCertDate">
          <el-input v-model="form.teacherCertDate" placeholder="请输入高校教师资格证书获取日期" />
        </el-form-item>
        <el-form-item label="职务等级" prop="professionalRank">
          <el-input v-model="form.professionalRank" placeholder="请输入职务等级" />
        </el-form-item>
        <el-form-item label="专业技术职务名称(最高)" prop="professionalTitle">
          <el-input v-model="form.professionalTitle" placeholder="请输入专业技术职务名称(最高)" />
        </el-form-item>
        <el-form-item label="专业技术职务发证单位" prop="professionalCertOrg">
          <el-input v-model="form.professionalCertOrg" placeholder="请输入专业技术职务发证单位" />
        </el-form-item>
        <el-form-item label="专业技术职务获取日期" prop="professionalCertDate">
          <el-input v-model="form.professionalCertDate" placeholder="请输入专业技术职务获取日期" />
        </el-form-item>
        <el-form-item label="证书等级" prop="certLevel">
          <el-input v-model="form.certLevel" placeholder="请输入证书等级" />
        </el-form-item>
        <el-form-item label="职业资格证书名称(最高)" prop="certName">
          <el-input v-model="form.certName" placeholder="请输入职业资格证书名称(最高)" />
        </el-form-item>
        <el-form-item label="职业资格证书发证单位" prop="certOrg">
          <el-input v-model="form.certOrg" placeholder="请输入职业资格证书发证单位" />
        </el-form-item>
        <el-form-item label="职业资格证书获取日期" prop="certDate">
          <el-input v-model="form.certDate" placeholder="请输入职业资格证书获取日期" />
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
        <el-form-item label="所任公共课程" prop="publicCourseName">
          <el-input v-model="form.publicCourseName" placeholder="请输入所任公共课程" />
        </el-form-item>
        <el-form-item label="是，担任年限" prop="majorLeaderYears">
          <el-input v-model="form.majorLeaderYears" placeholder="请输入是，担任年限" />
        </el-form-item>
        <el-form-item label="是，年限" prop="majorGroupLeaderYears">
          <el-input v-model="form.majorGroupLeaderYears" placeholder="请输入是，年限" />
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
import { listSchool_teacher_info, getSchool_teacher_info, delSchool_teacher_info, addSchool_teacher_info, updateSchool_teacher_info } from "@/api/dc/school_teacher_info"

export default {
  name: "School_teacher_info",
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
      // 1.4.1_校内教师基本信息表格数据
      school_teacher_infoList: [],
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
        idNumber: null,
        birthday: null,
        politicalStatus: null,
        nation: null,
        education: null,
        degree: null,
        staffType: null,
        position: null,
        majorField: null,
        specialty: null,
        hasTeacherCert: null,
        teacherCertOrg: null,
        teacherCertDate: null,
        professionalRank: null,
        professionalTitle: null,
        professionalCertOrg: null,
        professionalCertDate: null,
        certLevel: null,
        certName: null,
        certOrg: null,
        certDate: null,
        isMajorTeacher: null,
        adminMajorName: null,
        adminMajorCode: null,
        adminMajorLevel: null,
        adminMajorCategory: null,
        isPublicCourseTeacher: null,
        publicCourseName: null,
        doubleQualification: null,
        teachingMaster: null,
        isFulltimeIdeological: null,
        isParttimeIdeological: null,
        isFulltimeCounselor: null,
        isParttimeCounselor: null,
        isFulltimePsychology: null,
        isParttimePsychology: null,
        isMajorLeader: null,
        majorLeaderYears: null,
        majorGroupLeader: null,
        majorGroupLeaderYears: null,
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
          { required: true, message: "教工号不能为空", trigger: "blur" }
        ],
        name: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
        gender: [
          { required: true, message: "性别不能为空", trigger: "blur" }
        ],
        idNumber: [
          { required: true, message: "身份证号不能为空", trigger: "blur" }
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
        hasTeacherCert: [
          { required: true, message: "是否拥有高校教师资格证书不能为空", trigger: "blur" }
        ],
        isMajorTeacher: [
          { required: true, message: "是否专业教师不能为空", trigger: "blur" }
        ],
        isPublicCourseTeacher: [
          { required: true, message: "是否公共课教师不能为空", trigger: "blur" }
        ],
        doubleQualification: [
          { required: true, message: "是否为双师型教师不能为空", trigger: "blur" }
        ],
        teachingMaster: [
          { required: true, message: "教学名师不能为空", trigger: "blur" }
        ],
        isFulltimeIdeological: [
          { required: true, message: "是否专职思政课教师不能为空", trigger: "blur" }
        ],
        isParttimeIdeological: [
          { required: true, message: "是否兼职思政课教师不能为空", trigger: "blur" }
        ],
        isFulltimeCounselor: [
          { required: true, message: "是否专职辅导员不能为空", trigger: "blur" }
        ],
        isParttimeCounselor: [
          { required: true, message: "是否兼职辅导员不能为空", trigger: "blur" }
        ],
        isFulltimePsychology: [
          { required: true, message: "是否专职心理健康教师不能为空", trigger: "blur" }
        ],
        isParttimePsychology: [
          { required: true, message: "是否兼职心理健康教师不能为空", trigger: "blur" }
        ],
        isMajorLeader: [
          { required: true, message: "是否专业带头人不能为空", trigger: "blur" }
        ],
        majorGroupLeader: [
          { required: true, message: "是否专业不能为空", trigger: "blur" }
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
    /** 查询1.4.1_校内教师基本信息列表 */
    getList() {
      this.loading = true
      listSchool_teacher_info(this.queryParams).then(response => {
        this.school_teacher_infoList = response.rows
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
        idNumber: null,
        birthday: null,
        politicalStatus: null,
        nation: null,
        education: null,
        degree: null,
        staffType: null,
        position: null,
        majorField: null,
        specialty: null,
        hasTeacherCert: null,
        teacherCertOrg: null,
        teacherCertDate: null,
        professionalRank: null,
        professionalTitle: null,
        professionalCertOrg: null,
        professionalCertDate: null,
        certLevel: null,
        certName: null,
        certOrg: null,
        certDate: null,
        isMajorTeacher: null,
        adminMajorName: null,
        adminMajorCode: null,
        adminMajorLevel: null,
        adminMajorCategory: null,
        isPublicCourseTeacher: null,
        publicCourseName: null,
        doubleQualification: null,
        teachingMaster: null,
        isFulltimeIdeological: null,
        isParttimeIdeological: null,
        isFulltimeCounselor: null,
        isParttimeCounselor: null,
        isFulltimePsychology: null,
        isParttimePsychology: null,
        isMajorLeader: null,
        majorLeaderYears: null,
        majorGroupLeader: null,
        majorGroupLeaderYears: null,
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
      this.title = "添加1.4.1_校内教师基本信息"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getSchool_teacher_info(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改1.4.1_校内教师基本信息"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSchool_teacher_info(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addSchool_teacher_info(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除1.4.1_校内教师基本信息编号为"' + ids + '"的数据项？').then(function() {
        return delSchool_teacher_info(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('dc/school_teacher_info/export', {
        ...this.queryParams
      }, `school_teacher_info_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
