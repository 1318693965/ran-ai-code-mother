// @ts-ignore
/* eslint-disable */
import request from '@/request'

/** 健康检查 返回服务状态是否正常 GET /health/ */
export async function healthCheck(options?: { [key: string]: any }) {
  return request<API.BaseResponseString>('/health/', {
    method: 'GET',
    ...(options || {}),
  })
}
