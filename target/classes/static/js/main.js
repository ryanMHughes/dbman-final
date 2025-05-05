document.addEventListener('DOMContentLoaded', function () {
    var submittables = document.getElementsByClassName('submittable');
    for (var submittable of submittables) {
        submittable.addEventListener('keydown', function (e) {
            if (e.key === 'Enter' && !e.shiftKey) {
                e.preventDefault(); 
                this.form.submit(); 
                console.log(this.form + ' was submitted.');
            }
        });
    }
});

function triggerAdd(imageId, buttonElement) {
    fetch('/dataset/add/' + imageId, {
        method: 'POST'
    })
    .then(response => {
        if (response.ok) {
            console.log('Image added successfully');
            buttonElement.textContent = 'Remove';
                buttonElement.style.backgroundColor = 'red';
                buttonElement.onclick = function(event) {
                    event.stopPropagation();
                    triggerRemove(imageId, buttonElement);
                };
        } else {
            console.error('Failed to add image');
        }
    })
    .catch(error => console.error('Error:', error));
}

function triggerRemove(imageId, buttonElement) {
    fetch('/dataset/remove/' + imageId, {
        method: 'POST'
    })
    .then(response => {
        if (response.ok) {
            console.log('Image removed successfully');
            buttonElement.textContent = 'Add';
                buttonElement.style.backgroundColor = 'green';
                buttonElement.onclick = function(event) {
                    event.stopPropagation();
                    triggerAdd(imageId, buttonElement);
                };
        } else {
            console.error('Failed to remove image');
        }
    })
    .catch(error => console.error('Error:', error));
}