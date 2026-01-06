import request from "@/utils/request";

export function batchAdd(data) {
  return request({
    url: "/dm/taskdept/batchadd",
    method: "post",
    data: data,
  });
}
