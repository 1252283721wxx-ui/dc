import request from '@/utils/request'

// 查询学校获奖（荣誉）情况列表
export function listSchool_awards(query) {
  return request({
    url: '/dc/school_awards/list',
    method: 'get',
    params: query
  })
}

// 查询学校获奖（荣誉）情况详细
export function getSchool_awards(id) {
  return request({
    url: '/dc/school_awards/' + id,
    method: 'get'
  })
}

// 新增学校获奖（荣誉）情况
export function addSchool_awards(data) {
  return request({
    url: '/dc/school_awards',
    method: 'post',
    data: data
  })
}

// 修改学校获奖（荣誉）情况
export function updateSchool_awards(data) {
  return request({
    url: '/dc/school_awards',
    method: 'put',
    data: data
  })
}

// 删除学校获奖（荣誉）情况
export function delSchool_awards(id) {
  return request({
    url: '/dc/school_awards/' + id,
    method: 'delete'
  })
}
