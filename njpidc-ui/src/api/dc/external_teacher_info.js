import request from '@/utils/request'

// 查询1.4.2_校外教师基本情况列表
export function listExternal_teacher_info(query) {
  return request({
    url: '/dc/external_teacher_info/list',
    method: 'get',
    params: query
  })
}

// 查询1.4.2_校外教师基本情况详细
export function getExternal_teacher_info(id) {
  return request({
    url: '/dc/external_teacher_info/' + id,
    method: 'get'
  })
}

// 新增1.4.2_校外教师基本情况
export function addExternal_teacher_info(data) {
  return request({
    url: '/dc/external_teacher_info',
    method: 'post',
    data: data
  })
}

// 修改1.4.2_校外教师基本情况
export function updateExternal_teacher_info(data) {
  return request({
    url: '/dc/external_teacher_info',
    method: 'put',
    data: data
  })
}

// 删除1.4.2_校外教师基本情况
export function delExternal_teacher_info(id) {
  return request({
    url: '/dc/external_teacher_info/' + id,
    method: 'delete'
  })
}
