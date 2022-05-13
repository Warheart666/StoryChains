<template>
  <q-page class="flex flex-center">
    <v-network-graph
        :nodes="nodes"
        :edges="edges"
        :layouts="layouts"
        :configs="configs"
    />
  </q-page>
</template>

<style>
</style>

<script lang="ts">


import {defineComponent, reactive} from "vue"
import * as vNG from "v-network-graph";

export default defineComponent({
  name: 'HelloWorld',
  setup() {
    const nodes = {
      node1: {name: "Node 1"},
      node2: {name: "Node 2"},
      node3: {name: "Node 3"},
      node4: {name: "Node 4"},
    }
    const edges = {
      edge1: {source: "node1", target: "node2"},
      edge2: {source: "node2", target: "node3"},
      edge3: {source: "node3", target: "node4"},
    }
    const layouts = {
      nodes: {
        node1: {x: 0, y: 0},
        node2: {x: 50, y: 0},
        node3: {x: 100, y: 0},
        node4: {x: 150, y: 50},
      },
    }

    const configs = reactive(
        vNG.defineConfigs(
            {
              view: {autoPanAndZoomOnLoad: "fit-content"},
              edge: {
                gap: 5,
                type: "straight",
                margin: 2,
                marker: {
                  target: {
                    type: "arrow",
                    width: 4,
                    height: 4,
                    margin: -1,
                    units: "strokeWidth",
                    color: null
                  }
                }
              }
            }
        )
    )

    return {nodes, edges, layouts, configs}
  },
})
</script>