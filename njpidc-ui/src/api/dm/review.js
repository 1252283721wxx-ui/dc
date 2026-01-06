import request from '@/utils/request.js'

export function submit(data) { 
    return request({
      url: '/review/submit',
      method: 'post',
      data: data
    })
}