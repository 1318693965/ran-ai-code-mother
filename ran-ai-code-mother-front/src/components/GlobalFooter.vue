<template>
  <a-layout-footer class="global-footer">
    <div class="footer-container">
      <div class="footer-content">
        <span class="copyright-text">
          学习项目 by
          <a
            href="https://cn.vuejs.org/"
            target="_blank"
            rel="noopener noreferrer"
            class="author-link"
          >
            燃小宇
          </a>
        </span>
      </div>
    </div>
  </a-layout-footer>
</template>

<script setup lang="ts">
import { defineComponent } from 'vue'

defineComponent({
  name: 'GlobalFooter',
})
</script>

<style scoped>
.global-footer {
  background: #f0f2f5;
  border-top: 1px solid #e8e8e8;
  padding: 0;
  height: 70px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.footer-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 24px;
  width: 100%;
}

.footer-content {
  text-align: center;
}

.copyright-text {
  color: #666;
  font-size: 14px;
  line-height: 1.5;
}

.author-link {
  color: #1890ff;
  text-decoration: none;
  transition: color 0.3s;
}

.author-link:hover {
  color: #40a9ff;
  text-decoration: underline;
}

/* 响应式设计 */
@media (max-width: 768px) {
  .footer-container {
    padding: 0 16px;
  }

  .copyright-text {
    font-size: 12px;
  }
}
</style>