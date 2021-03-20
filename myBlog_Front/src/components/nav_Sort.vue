<template>
  <div class="nav_tags">
    <div class="nav_item">
      <router-link class="s-link" :to="{query: {sort: this.nav_List[0].sort}}">{{this.nav_List[0].text}}</router-link>
      <el-divider class="divider" direction="vertical"></el-divider>
      <router-link class="s-link" :to="{query: {sort: this.nav_List[1].sort}}">{{this.nav_List[1].text}}</router-link>
      <el-divider class="divider" direction="vertical"></el-divider>
      <router-link class="s-link" :to="{query: {sort: this.nav_List[2].sort}}">{{this.nav_List[2].text}}</router-link>
    </div>
    <el-divider class="divider"></el-divider>
  </div>
</template>

<script>
export default {
  data() {
    return {
      nav_List: [
        {
          sort: 'hot',
          text: '热门'
        },
        {
          sort: 'newest',
          text: '最新'
        },
        {
          sort: 'hottest',
          text: '热榜'
        },
      ],
    }
  },
}
</script>

<style lang="less">
.nav_item {
  height: 3.5rem;
  display: flex;
  align-items: center;
}
.s-link {
  color: #797E83;
  text-decoration: none;
  font-size: 1.2rem;
  margin: 1.5rem;
}
.s-link:hover {
  color: #007FFF;
}
.router-link-exact-active {
  color: #007FFF;
}
.divider {
  margin: 0 !important;
}
</style>