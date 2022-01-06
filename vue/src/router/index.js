import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/HomeView.vue'
import Login from '../views/LoginView.vue'
import Logout from '../views/LogoutView.vue'
import Register from '../views/RegisterView.vue'
import store from '../store/index'
import Cats from '../views/AllCatsView.vue'
import Dogs from '../views/AllDogsView.vue'
import Others from '../views/AllOthersView.vue'
import EditListing from '../views/EditPetListingView.vue'
import NotFound from '../views/NotFoundView.vue'
import PendingVols from '../views/PendingVolsView.vue'
import Directory from '../views/VolDirectoryView.vue'
import AddPet from '../views/AddPetListingView.vue'
import AboutUs from '../views/AboutUsView.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/cat",
      name: "Cats",
      component: Cats,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/dog",
      name: "Dogs",
      component: Dogs,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/other",
      name: "Others",
      component: Others,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/edit-listing/:id",
      name: "editListing",
      component: EditListing,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/not-found",
      name: "notFound",
      component: NotFound
    },
    {
      path: "/pending",
      name: "pendingVols",
      component: PendingVols,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/directory",
      name: "directory",
      component: Directory,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/add-pet",
      name: "addPet",
      component: AddPet,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/about-us",
      name: "aboutUs",
      component: AboutUs,
      meta: {
        requiresAuth: false
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
