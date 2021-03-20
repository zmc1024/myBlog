<template>
  <div id="wrapper">
    <!-- 头部 -->
    <v-header></v-header>
    
    <!-- 标签 -->
    <div class="view">
      <nav_Link></nav_Link>
      <router-view></router-view>
    </div>

    <el-backtop target=".page-component__scroll .el-scrollbar__wrap"></el-backtop>
  </div>
</template>

<script>
import header from '@/components/header'
import nav_Link from '@/components/nav_Link'
export default {
  data() {
    return {
      
    }
  },
  components: {
    'v-header': header,
    'nav_Link': nav_Link,
  },
  methods: {
    
  }
}
</script>

<style lang="less" scoped>
#wrapper {
  width: 100%;
  background-color: #F4F5F5;
  box-sizing: border-box;
}
</style>