// Function to handle form submission
function handleSubmit(event) {
    event.preventDefault(); // Prevent form submission
  
    // Get form data
    const formData = new FormData(event.target);
    const incidentData = {};
    formData.forEach((value, key) => {
      incidentData[key] = value;
    });
  
    // Send the data to the backend
    fetch('/api/incidents', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(incidentData),
    })
      .then((response) => response.json())
      .then((data) => {
        // Handle the response from the server (if needed)
        console.log('Incident data submitted:', data);
        // You can add further logic here based on the server response
      })
      .catch((error) => {
        // Handle errors (if any)
        console.error('Error submitting incident data:', error);
      });
  }
  
  // Listen for form submission event
  const incidentForm = document.getElementById('incidentForm');
  incidentForm.addEventListener('submit', handleSubmit);
  