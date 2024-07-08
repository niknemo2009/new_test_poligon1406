# Use a base image with a minimal Linux distribution
FROM ubuntu:latest

# Install dependencies
RUN apt-get update && \
    apt-get install -y wget gnupg

# Download and install Google Chrome
ENV CHROME_VERSION=120.0.6099.129-1
RUN wget -q https://dl.google.com/linux/chrome/deb/pool/main/g/google-chrome-stable/google-chrome-stable_${CHROME_VERSION}_amd64.deb
RUN apt-get -y update
RUN apt-get install -y ./google-chrome-stable_${CHROME_VERSION}_amd64.deb

# Clean up
RUN apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Set up a user to run Chrome (optional)
RUN useradd -m -G audio,video chromeuser && \
    mkdir -p /home/chromeuser/Downloads && \
    chown -R chromeuser:chromeuser /home/chromeuser

USER chromeuser

# Command to run Chrome
CMD ["google-chrome-stable"]