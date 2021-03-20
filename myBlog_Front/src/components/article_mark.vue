<template>
  <div>
    <mavon-editor
      v-model="articleContent.context"
      @change="change"
      style="display: none"
    />

    <div class="article-detail">
      <div class="user-detail">
        <div class="user-msg">
          <img class="user-avatar" src="../images/avatar.jpg" alt="">
          <span class="user-up">
            <div class="user-id">{{articleDetail.user_id}}</div>
            <div class="up-time">{{update_time}}</div>
          </span>
        </div>
        <el-button type="success" plain size="small">关注</el-button>
      </div>

      <article class="markdown-body" v-html="articleContent.context"></article>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      articleDetail: {},
      update_time: "",
      articleContent: {
        context: ""
      },
      ruleForm: {
        context_format: ""
      }
    }
  },
  props: {
    articleMap: {
      type: Object,
      default() {
        return {}
      }
    }
  },
  watch: {
    'articleMap': function (val) {   //监听props中的属性, props的值赋给data
      // console.log(val);
      this.articleDetail = val;
      this.update_time = val.update_time.slice(0,10)
      this.articleContent.context = val.content_format;
    }
  },
  methods: {
    // 文本渲染
    change(val, render) {   
      // console.log(render);
      this.ruleForm.context_format = render;
    },
  }
}
</script>

<style lang="less">
.article-detail {
  background-color: #fff;
  width: 65rem;
  margin: 1.7rem auto 0 auto;
}
.user-detail {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 94%;
  margin: 0 auto;
  padding-top: 2rem;
}
.user-msg {
  display: flex;
  align-items: center;
  justify-content: center;
}
.user-avatar {
  width: 3.5rem;
  height: 3.5rem;
}
.user-up {
  display: inline-block;
  margin-left: 1rem;
}
.user-id {
  font-size: 1.5rem;
  margin-bottom: 0.3rem;
}
.up-time {
  font-size: 1.17rem;
  color: #797E83;
}
.markdown-body {
  width: 94%;
  margin: 0 auto;
  padding: 2rem 0;
}
</style>