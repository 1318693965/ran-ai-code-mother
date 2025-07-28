<template>
  <a-layout-header class="global-header">
    <div class="header-container">
      <!-- 左侧 Logo 和标题 -->
      <div class="header-left">
        <div class="logo-container">
          <img src="@/assets/logo.png" alt="Logo" class="logo" />
          <h1 class="site-title">AI零代码生成平台</h1>
        </div>

        <!-- 菜单项 -->
        <a-menu
          mode="horizontal"
          :selected-keys="selectedKeys"
          class="header-menu"
          @click="handleMenuClick"
        >
          <a-menu-item key="home">
            <router-link to="/">首页</router-link>
          </a-menu-item>
          <a-menu-item key="about">
            <router-link to="/about">关于</router-link>
          </a-menu-item>
          <a-menu-item key="projects">
            <router-link to="/projects">项目</router-link>
          </a-menu-item>
          <a-menu-item key="resources">
            <router-link to="/resources">资源</router-link>
          </a-menu-item>
        </a-menu>
      </div>

      <!-- 右侧用户信息 -->
      <div class="header-right">
        <a-dropdown>
          <a-button type="text">
            <SettingOutlined />
          </a-button>
          <template #overlay>
            <a-menu>
              <a-menu-item @click="() => switchTheme('default')">
                <span>默认主题</span>
              </a-menu-item>
              <a-menu-item @click="() => switchTheme('dark')">
                <span>暗黑主题</span>
              </a-menu-item>
              <a-menu-item @click="() => switchTheme('compact')">
                <span>紧凑主题</span>
              </a-menu-item>
              <a-menu-divider />
              <a-menu-item @click="handleLogout">
                <span>登出</span>
              </a-menu-item>
            </a-menu>
          </template>
        </a-dropdown>
        <a-button type="primary" @click="handleLogin" v-if="!isLoggedIn">
          <template #icon>
            <UserOutlined />
          </template>
          登录
        </a-button>
        <a-dropdown v-else>
          <a-avatar style="background-color: #1890ff; vertical-align: middle" :size="32">
            U
          </a-avatar>
          <template #overlay>
            <a-menu>
              <a-menu-item @click="handleProfile">
                <span>个人资料</span>
              </a-menu-item>
              <a-menu-item @click="handleSettings">
                <span>设置</span>
              </a-menu-item>
              <a-menu-divider />
              <a-menu-item @click="handleLogout">
                <span>登出</span>
              </a-menu-item>
            </a-menu>
          </template>
        </a-dropdown>
      </div>
    </div>
  </a-layout-header>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'
import { useRoute } from 'vue-router'
import { UserOutlined, SettingOutlined } from '@ant-design/icons-vue'
import { message } from 'ant-design-vue'

const route = useRoute()
const isLoggedIn = ref(false) // 暂时设置为未登录状态

// 当前选中的菜单项
const selectedKeys = computed(() => {
  const path = route.path
  if (path === '/') return ['home']
  if (path === '/about') return ['about']
  if (path === '/projects') return ['projects']
  if (path === '/resources') return ['resources']
  return []
})

// 菜单点击处理
const handleMenuClick = ({ key }: { key: string }) => {
  console.log('菜单点击:', key)
}

// 登录处理
const handleLogin = () => {
  console.log('点击登录')
  // 这里可以添加登录逻辑
  message.success('登录成功')
  isLoggedIn.value = true
}

// 登出处理
const handleLogout = () => {
  console.log('点击登出')
  // 这里可以添加登出逻辑
  message.success('登出成功')
  isLoggedIn.value = false
}

// 个人资料
const handleProfile = () => {
  console.log('查看个人资料')
  message.info('查看个人资料')
}

// 设置
const handleSettings = () => {
  console.log('打开设置')
  message.info('打开设置')
}

// 切换主题
const switchTheme = (theme: string) => {
  console.log('切换主题:', theme)
  message.info(`切换到${theme === 'default' ? '默认' : theme === 'dark' ? '暗黑' : '紧凑'}主题`)
  
  // 实际切换主题的逻辑
  if (theme === 'dark') {
    document.body.setAttribute('data-theme', 'dark')
  } else if (theme === 'compact') {
    document.body.setAttribute('data-theme', 'compact')
  } else {
    document.body.removeAttribute('data-theme')
  }
  
  // 这里可以添加更复杂的主题切换逻辑
}
</script>

<style scoped>
.global-header {
  background: #fff;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1000;
  height: 64px;
  line-height: 64px;
}

.header-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 24px;
  height: 100%;
}

.header-left {
  display: flex;
  align-items: center;
}

.logo-container {
  display: flex;
  align-items: center;
  margin-right: 48px;
}

.logo {
  width: 32px;
  height: 32px;
  margin-right: 12px;
}

.site-title {
  font-size: 18px;
  font-weight: 600;
  color: #1890ff;
  margin: 0;
  line-height: 1;
}

.header-menu {
  border-bottom: none;
  background: transparent;
}

.header-menu :deep(.ant-menu-item) {
  border-bottom: none;
}

.header-menu :deep(.ant-menu-item a) {
  color: #333;
  text-decoration: none;
}

.header-menu :deep(.ant-menu-item-selected a) {
  color: #1890ff;
}

.header-right {
  display: flex;
  align-items: center;
  gap: 12px;
}

/* 响应式设计 */
@media (max-width: 768px) {
  .header-container {
    padding: 0 16px;
  }

  .logo-container {
    margin-right: 24px;
  }

  .site-title {
    font-size: 16px;
  }

  .header-menu {
    display: none; /* 在移动端隐藏菜单，可以考虑使用抽屉菜单 */
  }
}
</style>
