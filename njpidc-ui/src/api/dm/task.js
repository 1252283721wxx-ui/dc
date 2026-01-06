import request from '@/utils/request'

// 查询数据采集任务分配表列表
export function listTask(query) {
  return request({
    url: '/dm/task/list',
    method: 'get',
    params: query
  })
}

// 查询数据采集任务分配表详细
export function getTask(taskId) {
  return request({
    url: '/dm/task/' + taskId,
    method: 'get'
  })
}

// 新增数据采集任务分配表
export function addTask(data) {
  return request({
    url: '/dm/task',
    method: 'post',
    data: data
  })
}

// 修改数据采集任务分配表
export function updateTask(data) {
  return request({
    url: '/dm/task',
    method: 'put',
    data: data
  })
}

// 删除数据采集任务分配表
export function delTask(taskId) {
  return request({
    url: '/dm/task/' + taskId,
    method: 'delete'
  })
}
