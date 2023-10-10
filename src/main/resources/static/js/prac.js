// Get the lightning streak element
const lightningStreak = document.querySelector('.lightning-streak');

// Add a mousemove event listener to the document
document.addEventListener('mousemove', (event) => {
    // Update the lightning streak position
    lightningStreak.style.top = event.clientY + 'px';
    lightningStreak.style.left = event.clientX + 'px';

    // Create a trail of sparks behind the lightning streak
    const spark = document.createElement('div');
    spark.classList.add('spark');
    spark.style.top = event.clientY + 'px';
    spark.style.left = event.clientX + 'px';
    spark.style.opacity = 0.5;
    spark.style.animation = 'fade-out 0.5s ease-out';
    document.body.appendChild(spark);

    // Add a fade-out animation to the sparks
    spark.addEventListener('animationend', () => {
        spark.remove();
    });
});

