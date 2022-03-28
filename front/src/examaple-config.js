const config = {
    // elements: [
    //     {
    //         data: {id: "a"},
    //         position: {x: window.screen.width / 2 - 200, y: window.screen.height / 2},
    //         group: "nodes"
    //     },
    //     {
    //         data: {id: "b"},
    //         position: {x: window.screen.width / 2 + 200, y: window.screen.height / 2},
    //         group: "nodes"
    //     },
    //     {
    //         data: {id: "c"},
    //         position: {x: window.screen.width / 2 + 400, y: window.screen.height / 2},
    //         group: "nodes"
    //     },
    //     {
    //         data: {id: "ab", source: "a", target: "b"},
    //         group: "edges"
    //     },
    //     {
    //         data: {id: "bc", source: "b", target: "c"},
    //         group: "edges"
    //     }
    // ],
    style: [
        {
            selector: "node",
            style: {"background-color": "rgba(14,65,236,0.99)", label: "data(id)"}
        },
        {
            selector: "edge",
            style: {
                width: 7,
                'curve-style': 'bezier', //рисует стрелку
                "line-color": "rgba(59,205,19,0.79)",
                "target-arrow-color": "#dc1b1b",
                "target-arrow-shape": "triangle"
            }
        }
    ],
    layout: {name: "grid", rows: 1}
};

export default config;
