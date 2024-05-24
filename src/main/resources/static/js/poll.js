document.addEventListener('DOMContentLoaded', () => {
    const buttonsContainer = document.getElementById('previewOptionsContainer');
    const maxButtons = 6; // Максимальна кількість кнопок

    buttonsContainer.addEventListener('mouseover', (event) => {
        if (event.target.classList.contains('preview-button')) {
            event.target.textContent = 'Видалити';
        }
    });

    document.getElementById('addOptionBtn').addEventListener('click', () => {
        const text = document.getElementById('optionText').value.trim();
        const previewOptionsContainer = document.getElementById('previewOptionsContainer');
        const existingButtons = document.querySelectorAll('.preview-button');

        if (text && existingButtons.length < maxButtons) {
            const previewButton = document.createElement('button');
            previewButton.classList.add('preview-button');
            previewButton.textContent = text;
            previewOptionsContainer.appendChild(previewButton);

            previewButton.addEventListener('mouseover', (event) => {
                event.target.textContent = 'Видалити';
            });
            previewButton.addEventListener('mouseout', (event) => {
                event.target.textContent = text;
            });
            previewButton.addEventListener('click', (event) => {
                event.target.remove();
            });

            document.getElementById('optionText').value = '';

        }
    });
    document.getElementById('finishBtn').addEventListener('click', () => {
        const buttonNames = Array.from(document.querySelectorAll('.preview-button')).map(button => button.textContent);
        const surveyText = document.getElementById('questionText').value.trim();

        // if (buttonNames.len() < 1) {
        //
        // }

        // Виконати HTTP-запит тут з параметрами buttonNames та surveyText
        console.log('Назви кнопок:', buttonNames);
        console.log('Текст опитування:', surveyText);

        // Скористаємося fetch для виконання HTTP-запиту
        fetch('/api/constructor/poll', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                buttons: buttonNames,
                title: surveyText
            })
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text();
            })
            .then(data => {
                if (data) {
                    const jsonData = JSON.parse(data);
                    console.log('Отримано відповідь від сервера:', jsonData);
                } else {
                    console.log('No data received from server');
                }
                window.location.href = '/pollcabinet';
            })
            .catch(error => {
                console.error('Помилка:', error);
            });
    });
});
/*
fetch('/api/constructor/poll', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
        buttons: buttonNames,
        text: surveyText
    })
})
.then(response => {
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    return response.text();
})
.then(data => {
    if (data) {
        const jsonData = JSON.parse(data);
        console.log('Отримано відповідь від сервера:', jsonData);
    } else {
        console.log('No data received from server');
    }
})
.catch(error => {
    console.error('Помилка:', error);
});
 */