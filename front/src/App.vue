<template>
    <div id="app">
        <cytoscape
                :config="config"
                ref="cyRef"
                v-on:cxttapstart="updateNode"
                v-on:mousedown="addNode"
        >
            <cy-element
                    :definition="def"
                    :key="`${def.data.id}`"
                    v-for="def in elements"
                    v-on:mousedown="deleteNode($event, def.data.id)"
            />
        </cytoscape>
    </div>
</template>

<script>
    import Vue from 'vue'
    import config from "./examaple-config";
    import VueCytoscape from 'vue-cytoscape'
    import axios from 'axios'

    Vue.use(VueCytoscape)

    const elements = config.elements;
    delete config.elements;

    export default {
        data() {
            return {
                config,
                elements
            };
        },
        mounted() {
            this.getData()
        },
        methods: {
            getData() {
                axios
                    .get("http://localhost:8081/")
                    .then(response => {
                        console.log(response.data)
                    })
                    .catch(error => {
                        console.log(error)
                    })
            },
            addNode(event) {
                console.log(event.target, this.$refs.cyRef.instance);
                if (event.target === this.$refs.cyRef.instance)
                    console.log("adding node", event.target);
            },
            deleteNode(id) {
                console.log("node clicked", id);
            },
            updateNode(event) {
                console.log("right click node", event);
            },
            preConfig(cytoscape) {
                console.log("calling pre-config", cytoscape);
            },
            afterCreated(cy) {
                // cy: this is the cytoscape instance
                console.log("after created", cy);
            }
        }
    }
    ;
</script>

