<template>
  <div>
    <el-table
      :data="studentList"
      v-loading="loading"
      element-loading-text="加载中..."
      style="width: 100%"
    >
      <el-table-column prop="stuNo" label="学号" width="180"></el-table-column>
      <el-table-column prop="stuName" label="姓名" width="180">
      </el-table-column>
      <el-table-column prop="gender" label="性别" width="180">
      </el-table-column>
      <el-table-column prop="tel" label="电话" width="180"> </el-table-column>
      <el-table-column prop="grade" label="年级" width="180"> </el-table-column>
      <el-table-column prop="major" label="专业"> </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { listStudent } from "@/api/dc/student2";
export default {
  data() {
    return {
      loading: false,
    //   total: 0,
      studentList: [],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    getList() {
      this.loading = true;
      listStudent().then((response) => {
        console.log(response);
        this.studentList = response;
        // this.total = response.data.length;
        this.loading = false;
      });
    },
  },
};
</script>

<style lang="scss" scoped>
</style>