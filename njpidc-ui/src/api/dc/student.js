import request from '@/utils/request'

// 查询学生列表列表
export function listStudent(query) {
  return request({
    url: '/dc/student/list',
    method: 'get',
    params: query
  })
}

// 查询学生列表详细
export function getStudent(stuNo) {
  return request({
    url: '/dc/student/' + stuNo,
    method: 'get'
  })
}

// 新增学生列表
export function addStudent(data) {
  return request({
    url: '/dc/student',
    method: 'post',
    data: data
  })
}

// 修改学生列表
export function updateStudent(data) {
  return request({
    url: '/dc/student',
    method: 'put',
    data: data
  })
}

// 删除学生列表
export function delStudent(stuNo) {
  return request({
    url: '/dc/student/' + stuNo,
    method: 'delete'
  })
}
