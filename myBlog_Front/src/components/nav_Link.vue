<template>
  <div class="link">
    <nav class="nav">
      <span>
        <router-link class="tag-link" :to="item.to" v-for="item in nav_link" :key="item.id">{{item.text}}</router-link>
      </span>
      <router-link class="tag-link" to="/subscribe">标签管理</router-link>
    </nav>
    <el-divider class="divider"></el-divider>
  </div>
</template>

<script>
export default {
  data() {
    return {
      nav_link: [
        {
          id: 0,
          to: '/',
          text: '推荐'
        },
        {
          id: 1,
          to: '/following',
          text: '关注'
        },
        {
          id: 2,
          to: '/backend',
          text: '后端'
        },
        {
          id: 3,
          to: '/frontend',
          text: '前端'
        },
        {
          id: 4,
          to: '/android',
          text: 'Android'
        },
        {
          id: 5,
          to: '/ios',
          text: 'iOS'
        },
        {
          id: 6,
          to: '/ai',
          text: '人工智能'
        },
        {
          id: 7,
          to: '/freebie',
          text: '开发工具'
        },
        {
          id: 8,
          to: '/career',
          text: '代码人生'
        },
        {
          id: 9,
          to: '/read',
          text: '阅读'
        },
      ]
    }
  }
}
</script>

<style lang="less">
.link {
  width: 100%;
  background-color: #fff;
}
.nav {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 68%;
  margin: 0 auto;
  font-size: 1rem;
  height: 3.5rem;
}
.tag-link {
  color: #797E83;
  text-decoration: none;
  font-size: 1.2rem;
  margin: 1.5rem;
}
.tag-link:hover {
  color: #007FFF;
}
.router-link-exact-active {
  color: #007FFF;
}
.divider {
  margin: 0 !important;
}
</style>