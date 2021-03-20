<template>
  <div>
    <!-- 标签 -->
    <ul id="tag-ul">
      <li class="tag-li" v-for="item in tag_List" :key="item.id">
        <router-link class="t-link" :to="{path: '/backend'+item.to}">{{item.text}}</router-link>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    tag_List: {
      type: Array,
      default() {
        return []
      }
    }
  },
}
</script>

<style lang = "less">
#tag-ul {
  display: flex;
  margin-top: 0.8rem;
}
#tag-ul .tag-li {
  margin-right: 1.5rem;
  font-size: 15px;
  color: #797E83;
}
#tag-ul .tag-li .t-link {
  color: #797E83;
  text-decoration: none;
  background-color: #fff;
  border-radius: 1rem;
  margin: 0;
  padding: 3px 10px !important;
  font-size: 1.2rem;
}
#tag-ul .tag-li .t-link:hover {
  color: #007FFF;
}
.router-link-exact-active {
  color: #007FFF !important;
}
</style>