import request from '@/utils/request'

// 查询专业表列表
export function listMajor(query) {
  return request({
    url: '/student/major/list',
    method: 'get',
    params: query
  })
}

// 查询专业表详细
export function getMajor(id) {
  return request({
    url: '/student/major/' + id,
    method: 'get'
  })
}

// 新增专业表
export function addMajor(data) {
  return request({
    url: '/student/major',
    method: 'post',
    data: data
  })
}

// 修改专业表
export function updateMajor(data) {
  return request({
    url: '/student/major',
    method: 'put',
    data: data
  })
}

// 删除专业表
export function delMajor(id) {
  return request({
    url: '/student/major/' + id,
    method: 'delete'
  })
}
