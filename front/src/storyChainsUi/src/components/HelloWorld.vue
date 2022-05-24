<template>
    <q-page class="flex flex-center">
        <v-network-graph
                :configs="configs"
                :edges="edges"
                :nodes="nodes"
        />
    </q-page>
</template>

<style>
</style>

<script lang="js">

    import axios from 'axios'
    import * as vNG from "v-network-graph";
    //
    // const nodes = {
    //     node1: {name: "Node 1"},
    //     node2: {name: "Node 2"},
    //     node3: {name: "Node 3"},
    //     node4: {name: "Node 4"},
    // }
    // const edges = {
    //     edge1: {source: "node1", target: "node2"},
    //     edge2: {source: "node2", target: "node3"},
    //     edge3: {source: "node3", target: "node4"},
    // }
    // const layouts = {
    //     nodes: {
    //         node1: {x: 0, y: 0},
    //         node2: {x: 50, y: 0},
    //         node3: {x: 100, y: 0},
    //         node4: {x: 150, y: 0},
    //     },
    // }

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
            // layouts: layouts,
            edges: {},
            nodes: {}
            // edges: edges,
            // nodes: nodes
        }),
        mounted() {
            axios
                .get("http://localhost:8081/")
                .then(response => {
                    console.log(response.data)
                    let set = [];
                    response.data.chain.blocks.forEach((bl, idx) => {
                            const name = bl.sourceBlock.team.name
                            if (!set.includes(name)) {
                                set.push(name)
                                this.nodes['node' + bl.sourceBlock.id] = {'name': name}
                            }

                            bl.targetBlocks.forEach((tb, _idx) => {
                                // edge1: {source: "node1", target: "node2"},
                                this.edges['edge' + (idx + _idx)] = {
                                    'source': 'node' + bl.sourceBlock.id,
                                    'target': 'node' + tb.id
                                }
                            })
                        }
                    )


                    console.log("asdf")
                })
                .catch(error => {
                    console.log(error)
                })
        }

    }
</script>