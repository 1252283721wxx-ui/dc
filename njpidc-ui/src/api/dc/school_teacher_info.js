import request from '@/utils/request'

// 查询1.4.1_校内教师基本信息列表
export function listSchool_teacher_info(query) {
  return request({
    url: '/dc/school_teacher_info/list',
    method: 'get',
    params: query
  })
}

// 查询1.4.1_校内教师基本信息详细
export function getSchool_teacher_info(id) {
  return request({
    url: '/dc/school_teacher_info/' + id,
    method: 'get'
  })
}

// 新增1.4.1_校内教师基本信息
export function addSchool_teacher_info(data) {
  return request({
    url: '/dc/school_teacher_info',
    method: 'post',
    data: data
  })
}

// 修改1.4.1_校内教师基本信息
export function updateSchool_teacher_info(data) {
  return request({
    url: '/dc/school_teacher_info',
    method: 'put',
    data: data
  })
}

// 删除1.4.1_校内教师基本信息
export function delSchool_teacher_info(id) {
  return request({
    url: '/dc/school_teacher_info/' + id,
    method: 'delete'
  })
}
