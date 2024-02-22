document.getElementById('smsForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    var formData = new FormData(this);
    var jsonData = {};
    
    formData.forEach(function(value, key) {
        jsonData[key] = value;
    });
    
    fetch('http://localhost:8080/sms', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('response').innerText = 'SMS sent successfully!';
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('response').innerText = 'Failed to send SMS. Please try again later.';
    });
});
