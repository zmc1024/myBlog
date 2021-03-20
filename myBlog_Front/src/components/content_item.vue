<template>
  <div>
    <div id="content-item" v-for="item in dataList" :key="item.id" @click="send(item.id)">
      <div id="a-header">
        <a class="a-header-item">{{item.user_id}} * </a>
        <span class="a-header-time">{{item.update_time.slice(0,10)}} * </span>
        <a class="a-header-item" v-if="item.category_id == 0">后端 / </a>
        <a class="a-header-item" v-if="item.category_id == 1">前端 / </a>
        <a class="a-header-item">{{item.tag}}</a>
      </div>
      <a id="a-title">{{item.title}}</a>
      <div id="a-icon">
        <span class="a-icon-item"><i class="el-icon-thumb"> 12</i></span>
        <a class="a-icon-item"><i class="el-icon-chat-round"> 12</i></a>
      </div>
      <el-divider class="divider"></el-divider>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dataList: []
    }
  },
  props: {
    articleList: {
      type: Array,
      default() {
        return []
      }
    }
  },
  watch: {
    'articleList': function (val) {   //监听props中的属性, props的值赋给data
      this.dataList = val;
    }
  },
  methods: {
    send(e) {
      let articleid = e;
      this.$router.push({path: '/post', query: {articleid}});   // 跳转页面
    }
  }
}
</script>

<style lang = "less">
#content-item {
  cursor: pointer
}
#content-item:hover {
  background-color: #FCFCFC;
}
#a-header {
  color: #797E83;
  margin: 0 0 0.5rem 1.5rem;
  padding-top: 1.5rem;
}
.a-header-item, .a-header-time {
  font-size: 1.13rem;
}
.a-header-item:hover {
  color: #007FFF;
}
#a-title {
  font-weight: bold;
  margin: 0 0 0.5rem 1.5rem;
  font-size: 1.5rem;
}
#a-title:hover {
  text-decoration:underline;
}
#a-title:visited {
  color: #909090;
}
#a-icon {
  margin: 1rem 0 1rem 1.5rem;
}
.a-icon-item {
  display: inline-block;
  border: 1px solid #DCDFE6;
  padding: 0.3rem 1rem;
}
.a-icon-item:hover {
  background-color: #F7F8FA;
}
.el-icon-thumb, .el-icon-chat-round {
  color: #B2BAC2;
}
</style>