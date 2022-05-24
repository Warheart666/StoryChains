<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated class="glossy">
      <q-toolbar>
        <q-btn
            flat
            dense
            round
            @click="leftDrawerOpen = !leftDrawerOpen"
            aria-label="Menu"
            icon="menu"
        />

        <q-toolbar-title>
          StoryChains App
        </q-toolbar-title>

        <div>Quasar v{{ $q.version }}</div>
      </q-toolbar>
    </q-header>

    <q-drawer
        v-model="leftDrawerOpen"
        show-if-above
        bordered
        class="bg-grey-2"
    >
      <q-list>
        <q-item-label header>Main menu</q-item-label>
        <q-item clickable>
          <q-item-section avatar>
            <q-icon name="school"/>
          </q-item-section>
          <q-item-section>
            <q-item-label>Docs</q-item-label>
            <q-item-label caption>quasar.dev</q-item-label>
          </q-item-section>
        </q-item>
      </q-list>
    </q-drawer>

    <q-page-container>
      <HelloWorld/>
    </q-page-container>
  </q-layout>
</template>

<script>
    import HelloWorld from './components/HelloWorld.vue'

    export default {
      name: 'LayoutDefault',

      components: {
        HelloWorld
      },
      data: () => ({
        leftDrawerOpen: true
      })
    }
</script>
