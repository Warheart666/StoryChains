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

<script lang="js">

import axios from 'axios'
import * as vNG from "v-network-graph";

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

const configs = vNG.defineConfigs(
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


export default {
  name: 'HelloWorld',
  data: () => ({
    configs: configs,
    layouts: layouts,
    edges: edges,
    nodes: nodes
  }),
  mounted() {
    axios
        .get("http://localhost:8081/")
        .then(response => {
          console.log(response.data)
          let elements = [];

          response.data.chain.blocks.map(bl => {

                // let xPos = indx > length / 2 ? bl.sourceBlock.id * 100 : bl.sourceBlock.id * -100
                let xPos = bl.sourceBlock.id * 100

                return {
                  "data": {"id": bl.sourceBlock.id, "name": bl.sourceBlock.team.name},
                  "position": {"x": window.screen.width / 2 + xPos, y: window.screen.height / 2},
                  "group": "nodes"
                }
              }
          ).forEach(value => elements.push(value))

          response.data.chain.blocks.flatMap(bl => {
            return bl.targetBlocks.map(tbl => {
                  return {
                    data: {
                      id: bl.sourceBlock.id.toString() + tbl.id.toString(),
                      source: bl.sourceBlock.id,
                      target: tbl.id
                    },
                    group: "edges"
                  }
                }
            )
          }).forEach(value => elements.push(value))

          this.elements = elements
          console.log(this.elements)


        })
        .catch(error => {
          console.log(error)
        })
  }

}
</script>