# rest-service
Sample request

{
    "customerName": {
        "purchases": [
            {
                "month": "jan",
                "values": [
                    12,
                    122,
                    123,
                    33
                ]
            },
            {
                "month": "Feb",
                "values": [
                    122,
                    321,
                    233,
                    212
                ]
            }
        ]
    },
    "customerName2": {
        "purchases": [
            {
                "month": "jan",
                "values": [
                    12,
                    0,
                    11,
                    33
                ]
            },
            {
                "month": "Feb",
                "values": [
                    120,
                    321,
                    22,
                    22
                ]
            }
        ]
    }
}

sample reply:

{
    "Customer Name": "customerName",
    "points": [
        {
            "month": "Feb",
            "point": "1176"
        },
        {
            "month": "jan",
            "point": "190"
        }
    ],
    "Customer Name": "customerName2",
    "points": [
        {
            "month": "Feb",
            "point": "582"
        },
        {
            "month": "jan",
            "point": "0"
        }
    ]
}
