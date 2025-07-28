<script setup lang="ts">
import BasicLayout from '@/layouts/BasicLayout.vue'
import { healthCheck } from '@/api/jiankangjianchajiekou.ts'

healthCheck().then((res) => {
  console.log(res)
})

</script>

<template>
  <div id="app">
    <BasicLayout />
  </div>
</template>

<style>
#app {
  min-height: 100vh;
}

/* 默认主题样式 */
:root {
  --theme-color: #1890ff;
}

/* 暗黑主题样式 */
[data-theme='dark'] {
  --theme-color: #177ddc;
}

/* 紧凑主题样式 */
[data-theme='compact'] {
  --theme-color: #1890ff;
}
</style>
