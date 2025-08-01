<script setup lang="ts">
import { defineComponent } from 'vue'

defineComponent({
  name: 'HomeView',
})
</script>

<template>
  <div class="home-container">
    <a-card title="欢迎来到AI零代码生成平台" class="welcome-card">
      <template #extra>
        <a-tag color="blue">新功能</a-tag>
      </template>

      <div class="welcome-content">
        <a-typography>
          <a-typography-title :level="2"> 欢迎使用AI零代码生成平台 </a-typography-title>

          <a-typography-paragraph>
            这是一个基于 Vue 3 + TypeScript + Ant Design Vue 构建的现代化前端项目。
          </a-typography-paragraph>

          <a-typography-paragraph> 项目特点： </a-typography-paragraph>

          <a-typography-paragraph>
            <ul>
              <li>使用 Vue 3 组合式 API</li>
              <li>TypeScript 类型支持</li>
              <li>Ant Design Vue 组件库</li>
              <li>响应式设计</li>
              <li>模块化布局</li>
            </ul>
          </a-typography-paragraph>

          <a-divider />

          <a-space>
            <a-button type="primary" size="large"> 开始使用 </a-button>
            <a-button size="large"> 了解更多 </a-button>
          </a-space>
        </a-typography>
      </div>
    </a-card>

    <a-row :gutter="16" class="feature-cards">
      <a-col :span="8">
        <a-card title="快速开发" hoverable>
          <template #cover>
            <div class="card-cover">
              <a-icon type="rocket" style="font-size: 48px; color: #1890ff" />
            </div>
          </template>
          <p>基于现代化的技术栈，提供快速开发体验</p>
        </a-card>
      </a-col>

      <a-col :span="8">
        <a-card title="组件丰富" hoverable>
          <template #cover>
            <div class="card-cover">
              <a-icon type="appstore" style="font-size: 48px; color: #52c41a" />
            </div>
          </template>
          <p>内置丰富的 UI 组件，满足各种业务需求</p>
        </a-card>
      </a-col>

      <a-col :span="8">
        <a-card title="响应式设计" hoverable>
          <template #cover>
            <div class="card-cover">
              <a-icon type="mobile" style="font-size: 48px; color: #faad14" />
            </div>
          </template>
          <p>完美适配各种设备，提供优秀的用户体验</p>
        </a-card>
      </a-col>
    </a-row>
  </div>
</template>

<style scoped>
.home-container {
  max-width: 1200px;
  margin: 0 auto;
}

.welcome-card {
  margin-bottom: 24px;
}

.welcome-content {
  padding: 16px 0;
}

.feature-cards {
  margin-top: 24px;
}

.card-cover {
  height: 120px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: #fafafa;
}

/* 响应式设计 */
@media (max-width: 768px) {
  .feature-cards .ant-col {
    margin-bottom: 16px;
  }
}
</style>
