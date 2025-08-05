<template>
  <a-layout-header class="global-header">
    <div class="header-container">
      <!-- 左侧 Logo 和标题 -->
      <div class="header-left">
        <div class="logo-container">
          <img src="@/assets/logo.png" alt="Logo" class="logo" />
          <h1 class="site-title">编程导航</h1>
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
      <div class="user-login-status">
        <div v-if="loginUserStore.loginUser.id">
          <a-dropdown>
            <a-space>
              <a-avatar :src="loginUserStore.loginUser.userAvatar" />
              {{ loginUserStore.loginUser.userName ?? '无名' }}
            </a-space>
            <template #overlay>
              <a-menu>
                <a-menu-item @click="doLogout">
                  <LogoutOutlined />
                  退出登录
                </a-menu-item>
              </a-menu>
            </template>
          </a-dropdown>
        </div>
        <div v-else>
          <a-button type="primary" href="/user/login">登录</a-button>
        </div>
      </div>

    </div>
  </a-layout-header>
</template>

<script setup lang="ts">
import { computed, h } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { UserOutlined, LogoutOutlined, HomeOutlined } from '@ant-design/icons-vue'
import { useLoginUserStore } from '@/stores/loginUser.ts'
import { userLogout } from '@/api/userController.ts'
import { type MenuProps, message } from 'ant-design-vue'

// JS 中引入 Store
const loginUserStore = useLoginUserStore()
const router = useRouter()
// HTML 展示数据
{{ JSON.stringify(loginUserStore.loginUser) }}

const route = useRoute()

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
}

// 用户注销
const doLogout = async () => {
  const res = await userLogout()
  if (res.data.code === 0) {
    loginUserStore.setLoginUser({
      userName: '未登录',
    })
    message.success('退出登录成功')
    await router.push('/user/login')
  } else {
    message.error('退出登录失败，' + res.data.message)
  }
}

// 菜单配置项
const originItems = [
  {
    key: '/',
    icon: () => h(HomeOutlined),
    label: '主页',
    title: '主页',
  },
  {
    key: '/admin/userManage',
    label: '用户管理',
    title: '用户管理',
  },
  {
    key: 'others',
    label: h('a', { href: 'https://www.codefather.cn', target: '_blank' }, '编程导航'),
    title: '编程导航',
  },
]

// 过滤菜单项
const filterMenus = (menus = [] as MenuProps['items']) => {
  return menus?.filter((menu) => {
    const menuKey = menu?.key as string
    if (menuKey?.startsWith('/admin')) {
      const loginUser = loginUserStore.loginUser
      if (!loginUser || loginUser.userRole !== 'admin') {
        return false
      }
    }
    return true
  })
}

// 展示在菜单的路由数组
const menuItems = computed<MenuProps['items']>(() => filterMenus(originItems))

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
