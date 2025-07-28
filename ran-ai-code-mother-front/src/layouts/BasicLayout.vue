<template>
  <a-layout class="basic-layout">
    <!-- 头部导航 -->
    <GlobalHeader />

    <!-- 内容区域 -->
    <a-layout-content class="layout-content">
      <router-view />
    </a-layout-content>

    <!-- 底部版权 -->
    <GlobalFooter />
  </a-layout>
</template>

<script setup lang="ts">
import { defineComponent } from 'vue'
import GlobalHeader from '@/components/GlobalHeader.vue'
import GlobalFooter from '@/components/GlobalFooter.vue'

defineComponent({
  name: 'BasicLayout',
})
</script>

<style scoped>
.basic-layout {
  min-height: 100vh;
}

.layout-content {
  padding: 24px;
  background: #fff;
  min-height: calc(100vh - 64px - 70px); /* 减去头部和底部的高度 */
  margin-top: 64px; /* 为固定头部留出空间 */
}

/* 响应式设计 */
@media (max-width: 768px) {
  .layout-content {
    padding: 16px;
  }
}
</style>
