const apiBase = "http://localhost:8080/api/converter";

function loadUnits() {
    const type = document.getElementById("conversionType").value;
    const fromUnit = document.getElementById("fromUnit");
    const toUnit = document.getElementById("toUnit");

    let units = [];
    if (type === "length") {
        units = ["meters", "kilometers", "feet"];
    } else if (type === "weight") {
        units = ["grams", "kilograms", "pounds"];
    } else if (type === "temperature") {
        units = ["celsius", "fahrenheit"];
    }

    fromUnit.innerHTML = units.map(u => `<option value="${u}">${u}</option>`).join('');
    toUnit.innerHTML = units.map(u => `<option value="${u}">${u}</option>`).join('');
}

function convert() {
    const type = document.getElementById("conversionType").value;
    const value = document.getElementById("value").value;
    const fromUnit = document.getElementById("fromUnit").value;
    const toUnit = document.getElementById("toUnit").value;

    const url = `${apiBase}/${type}?value=${value}&fromUnit=${fromUnit}&toUnit=${toUnit}`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            document.getElementById("result").innerText = `Result: ${data}`;
        })
        .catch(error => {
            console.error("Error:", error);
            document.getElementById("result").innerText = "Error: Could not convert.";
        });
}


loadUnits();
