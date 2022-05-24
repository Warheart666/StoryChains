<template>
    <q-page class="flex flex-center">
        <div class="row full-width" ref="netGraph">
            <v-network-graph
                    :configs="configs"
                    :edges="edges"
                    :layouts="layouts"
                    :nodes="nodes"
                    :zoom-level="2"
            />
        </div>
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
            view: {scalingObjects: true, autoPanAndZoomOnLoad: "center-content"},
            path: {visible: 'true'},
            edge: {
                keepOrder: 'vertical',
                gap: 8,
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
            layouts: {nodes: {}},
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
                    let clientWidth = this.$refs.netGraph.clientWidth;
                    let indent = clientWidth / new Set(response.data.chain.blocks).size;
                    // let lo = {}
                    // let sorted = response.data.chain.blocks.sort((x, y) => x.sourceBlock.id - y.sourceBlock.id).map(bl => {
                    //     if (bl.prevBlock === null)
                    //         lo[bl.sourceBlock.id] = 0
                    //     else
                    // });


                    response.data.chain.blocks.forEach((bl, idx) => {
                            const name = bl.sourceBlock.team.name
                            if (!set.includes(name)) {
                                set.push(name)
                                this.nodes['node' + bl.sourceBlock.id] = {'name': name}
                                // this.layouts.nodes['node' + bl.sourceBlock.id] = getCoordinates(indent, idx)
                            }

                            bl.targetBlocks.forEach((tb, _idx) => {
                                this.edges['edge' + (idx + _idx)] = {
                                    'source': 'node' + bl.sourceBlock.id,
                                    'target': 'node' + tb.id
                                }
                            })
                        }
                    )
                    this.layouts.nodes = getCoordinates(response.data.chain.blocks)

                })
                .catch(error => {
                    console.log(error)
                })
        }

    }

    function getCoordinates(blocks, indent, idx) {
        let nodes = {}
        let uniqBl = []
        let root = blocks.filter(bl => bl.prevBlock === null)[0]
        let counter = 0
        processing(root)

        function processing(bl) {
            console.log(++counter)
            if (bl !== null && !uniqBl.includes(bl.sourceBlock.id)) {

                uniqBl.push(bl.sourceBlock.id)
                nodes["node" + bl.sourceBlock.id] = {'x': 0, 'y': 0}

                bl.targetBlocks.filter(tb => tb !== null && tb.id !== root.sourceBlock.id).forEach(tb => {
                    console.log('target block ' + tb.id)
                    processing(blocks.filter(searchBl => searchBl.sourceBlock.id === tb.id)[0])
                })


            }
        }

    }
</script>