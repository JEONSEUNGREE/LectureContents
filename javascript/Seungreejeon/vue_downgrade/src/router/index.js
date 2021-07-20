import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test from '../views/Test.vue'
import Todo from '../views/Todo.vue'
import Homework from '../views/Homework.vue'

// board
import BoardListPage from '@/views/BoardListPage.vue'
import BoardRegisterPage from '@/views/BoardRegisterPage.vue'
import BoardReadPage from '@/views/BoardReadPage.vue'
import BoardModifyPage from '@/views/BoardModifyPage.vue'

// game
import GameMemberRegisterPage from '@/views/GameMemberRegister.vue'

// product
import ProductListPage from '@/views/ProductListPage.vue'
import ProductRegisterPage from '@/views/ProductRegisterPage.vue'

//삼목
import Concave from '@/views/Concave.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/test',
    name: 'Test',
    component: Test
  },
  {
    path: '/todo',
    name: 'Todo',
    component: Todo
  },
  {
    path: '/homework',
    name: 'Homework',
    component: Homework
  },
  {
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    path: '/board/create',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
    {
    path: '/member/create',
    name: 'GameMemberRegisterPage',
    components: {
      default: GameMemberRegisterPage
    }
  },
    {
        path: '/board/:boardNo',
        name: 'BoardReadPage',
        components: {
          default: BoardReadPage
        },
        props: {
          default: true
        }
  },
  {
    path: '/board/:boardNo/edit',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      // 라우팅 파라미터를 props에 자동으로 설정하게 서포트한다.
      default: true
    },
},
{
    path: '/concave',
    name: 'Concave',
    components: {
      default: Concave
  }
},
{
  path: '/product',
  name: 'ProductListPage',
  components: {
    default: ProductListPage
  }
},
{
  path: '/product/create',
  name: 'ProductRegisterPage',
  components: {
    default: ProductRegisterPage
  }
},
]
// 파라미터로 받게 되있다. props로 받는것 자동 :x는 가변인자
const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router