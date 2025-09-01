const apiUrl = "http://localhost:8080/OrchApi/webresources/api";

// Fetch Rooms
document.getElementById("fetchRooms").addEventListener("click", async () => {
    const output = document.getElementById("roomsOutput");
    output.innerHTML = "Loading rooms...";
    try {
        const response = await fetch(`${apiUrl}`);
        if (response.ok) {
            const data = await response.json();
            output.innerHTML = `<pre>${JSON.stringify(data, null, 2)}</pre>`;
        } else {
            output.innerHTML = `Error: ${response.statusText}`;
        }
    } catch (error) {
        output.innerHTML = `Error: ${error.message}`;
    }
});

// Submit Application
document.getElementById("applicationForm").addEventListener("submit", async (e) => {
    e.preventDefault();
    const appName = document.getElementById("appName").value;
    const appDetails = document.getElementById("appDetails").value;
    try {
        const response = await fetch(`${apiUrl}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ name: appName, details: appDetails })
        });
        if (response.ok) {
            const data = await response.json();
            alert(`Application Submitted! ID: ${data.appId}`);
        } else {
            alert(`Error: ${response.statusText}`);
        }
    } catch (error) {
        alert(`Error: ${error.message}`);
    }
});

// Fetch Applications
document.getElementById("fetchApplications").addEventListener("click", async () => {
    const output = document.getElementById("applicationsOutput");
    output.innerHTML = "Loading applications...";
    try {
        const response = await fetch(`${apiUrl}/applications`);
        if (response.ok) {
            const data = await response.json();
            output.innerHTML = `<pre>${JSON.stringify(data, null, 2)}</pre>`;
        } else {
            output.innerHTML = `Error: ${response.statusText}`;
        }
    } catch (error) {
        output.innerHTML = `Error: ${error.message}`;
    }
});

// Delete Application
document.getElementById("deleteForm").addEventListener("submit", async (e) => {
    e.preventDefault();
    const deleteId = document.getElementById("deleteId").value;
    try {
        const response = await fetch(`${apiUrl}/Del/${deleteId}`, { method: "DELETE" });
        if (response.ok) {
            alert("Application deleted successfully!");
        } else {
            alert(`Error: ${response.statusText}`);
        }
    } catch (error) {
        alert(`Error: ${error.message}`);
    }
});
