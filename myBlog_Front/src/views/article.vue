<template>
  <div id="app">
    <div id="header">
      <span class="edit">EDIT BLOG</span>
      <div class="user">
        <img class="avatar" src="../images/avatar.png" alt="">
        <span class="username">{{ruleForm.userName}}</span>
      </div>
    </div>
    <el-form
      :model="ruleForm"
      :rules="rules"
      ref="ruleForm"
      label-width="100px"
      class="demo-ruleForm"
    >
      <el-form-item class="blog-title" label="博文标题" prop="title">
        <el-input style="width: 50%"
          v-model="ruleForm.title"
          placeholder="请输入博文标题"
        ></el-input>
        <span class="blog-button">
          <el-button @click="resetForm('ruleForm')">重置</el-button>
          <el-button type="info">保存草稿</el-button>
          <el-button type="primary" @click="submitForm('ruleForm')">发布文章</el-button>
        </span>
      </el-form-item>
      <el-row>
        <el-col :span="6">
          <el-form-item label="博文分类" prop="category">
            <el-select
              v-model="ruleForm.category"
              style="width: 100%"
              placeholder="请选择"
            >
              <el-option
                v-for="item in ruleForm.category_options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="博文标签" prop="tag">
            <el-select
              v-model="ruleForm.tag"
              multiple
              allow-create
              filterable
              style="width: 100%"
              placeholder="搜索Java试试"
            >
              <el-option
                v-for="item in ruleForm.tag_options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="发布形式" prop="resource">
        <el-radio-group v-model="ruleForm.resource">
          <el-radio :label="0">公开</el-radio>
          <el-radio :label="1">私密</el-radio>
          <el-radio :label="2">仅粉丝可见</el-radio>
        </el-radio-group>
      </el-form-item>
      <div class="marker">
        <mavon-editor
          v-model="ruleForm.context"
          :toolbars="ruleForm.toolbars"
          @change="change"
          style="min-height: 40rem; height: 100%; width: 100%; z-index: 9"
        />
        <!-- <article class="markdown-body" v-html="ruleForm.contexts"></article> -->
      </div>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        userName: "",
        title: "", // 博文标题
        category: "", // 博文分类
        category_options: [ // 分类详细
          {
            value: 0,
            label: "后端",
          },
          {
            value: 1,
            label: "前端",
          },
          {
            value: 2,
            label: "iOS",
          },
          {
            value: 3,
            label: "Android",
          },
          {
            value: 4,
            label: "人工智能",
          },
          {
            value: 5,
            label: "开发工具",
          },
          {
            value: 6,
            label: "代码人生",
          },
          {
            value: 7,
            label: "其他",
          },
        ],
        tag: "", // 博文标签
        tag_options: [  // 标签详细
          {
            value: "Java",
            label: "Java",
          },
          {
            value: "JavaScript",
            label: "JavaScript",
          },
          {
            value: "C",
            label: "C",
          },
          {
            value: "C++",
            label: "C++",
          },
          {
            value: "Python",
            label: "Python",
          },
          {
            value: "Vue",
            label: "Vue",
          },
          {
            value: "React",
            label: "React",
          },
          {
            value: "Node.js",
            label: "Node.js",
          },
          {
            value: "ElasticSearch",
            label: "ElasticSearch",
          },
          {
            value: "面试",
            label: "面试",
          },
        ],
        resource: 0,   // 发布形式
        context_format: "",  // 渲染的html数据
        context: "", //输入的数据
        toolbars: {     // 富文本按钮功能
          bold: true, // 粗体
          italic: true, // 斜体
          header: true, // 标题
          underline: true, // 下划线
          strikethrough: true, // 中划线
          mark: true, // 标记
          superscript: true, // 上角标
          subscript: true, // 下角标
          quote: true, // 引用
          ol: true, // 有序列表
          ul: true, // 无序列表
          link: true, // 链接
          imagelink: true, // 图片链接
          code: true, // code
          table: true, // 表格
          fullscreen: true, // 全屏编辑
          readmodel: true, // 沉浸式阅读
          htmlcode: true, // 展示html源码
          help: true, // 帮助
          /* 1.3.5 */
          undo: true, // 上一步
          redo: true, // 下一步
          trash: true, // 清空
          save: true, // 保存（触发events中的save事件）
          /* 1.4.2 */
          navigation: true, // 导航目录
          /* 2.1.8 */
          alignleft: true, // 左对齐
          aligncenter: true, // 居中
          alignright: true, // 右对齐
          /* 2.2.1 */
          subfield: true, // 单双栏模式
          preview: true, // 预览
        },
      },
      rules: {
        title: [{ required: true, message: "请输入博文标题", trigger: "blur" }],
        category: [
          { required: true, message: "请选择分类", trigger: "change" },
        ],
        tag: [{ required: true, message: "请选择标签", trigger: "blur" }],
        resource: [
          { required: true, message: '请选择发布形式', trigger: 'change' }
        ],
      },
    };
  },
  methods: {
    // 文本渲染
    change(val, render) {   
      this.ruleForm.context_format = render;
    },

    // 发布文章
    submitForm(formName) {      
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          // console.log(this.ruleForm);
          let { category, context, context_format, resource, tag, title, userName } = this.ruleForm
          let tagString = tag.toString();
          let articleObject = {
            "user_id": userName,
            "title": title,
            "category_id": category,
            "tag": tagString,
            "type": resource,
            "content": context,
            "content_format": context_format
          }
          // console.log(articleObject);
          const res = await this.$http.post("publish", articleObject);
          console.log(res);
          if(res.status === 200) {
            this.$message.success("文章发布成功 ~ ");
            setTimeout(() => {
              this.$router.push({path: '/'});
            }, 1000)
          }
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },

    // 重置
    resetForm(formName) {       
      this.$refs[formName].resetFields();
    },
  },
  mounted() {
    this.ruleForm.userName = localStorage.getItem("username")
  }
};
</script>

<style lang="less">
#app {
  background-color: #F1F4F5;
  min-height: 100vh;
  height: 100%;
}
#header {
  background-color: #16B2A3;
  height: 4rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
  color: #fff;
}
.blog-button {
  margin-left: 23rem;
}
.edit {
  font-weight: bold;
  font-size: 20px;
  margin-left: 5rem;
}
.user{
  margin-right: 3rem;
  display: flex;
  align-items: center;
  justify-content: center;
}
.avatar {
  width: 30px;
  height: 30px;
  margin-right: 3px;
}
.demo-ruleForm {
  width: 85%;
  margin: 0 auto;
  padding-top: 17px;
  margin-top: 13px;
  background-color: #fff;
}
.marker {
  margin: 0 auto;
  width: 97%;
  padding-bottom: 17px;
}
</style>