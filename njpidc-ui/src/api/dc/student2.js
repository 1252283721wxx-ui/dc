import request from "@/utils/request";

export function listStudent() {
  return request({
    url: "/student/list",
    method: "get",
  });
}
