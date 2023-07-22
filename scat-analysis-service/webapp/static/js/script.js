document.addEventListener('DOMContentLoaded', function () {
    // Get the incident form element
    var incidentForm = document.getElementById('incidentForm');

    // Add event listener to submit button
    incidentForm.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent form submission

        // Collect form data
        var formData = {
            name: document.getElementById('name').value,
            date: document.getElementById('date').value,
            location: document.getElementById('location').value,
            summary: document.getElementById('summary').value,
            immediateActions: document.getElementById('immediateActions').value,
            incidentType: document.getElementById('incidentType').value,
            incidentClassification: document.getElementById('incidentClassification').value,
            immediateCauses: document.getElementById('immediateCauses').value,
            basicCauses: document.getElementById('basicCauses').value
        };

        // Send form data to backend
        fetch('/incidents', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
        .then(function (response) {
            if (response.ok) {
                // Form submission successful
                alert('Incident saved successfully!');
                incidentForm.reset(); // Reset the form
            } else {
                // Form submission failed
                alert('Error saving incident. Please try again.');
            }
        })
        .catch(function (error) {
            console.error('Error:', error);
            alert('An error occurred while saving the incident. Please try again.');
        });
    });
});
