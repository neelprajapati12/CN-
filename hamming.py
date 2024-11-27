# Input data and parity type
data = input("Enter 4-bit or 5-bit data: ")
parity = input("Enter parity type (even/odd): ").lower()

# Calculate Hamming code
n = len(data)
m = 0
while (2 ** m) < (n + m + 1):
    m += 1

hamming = [None] * (n + m)
j = 0

# Place data bits in non-power-of-2 positions
for i in range(len(hamming)):
    if (i + 1) & i == 0:  # Power of 2 positions
        continue
    hamming[i] = int(data[j])
    j += 1

# Calculate parity bits
for i in range(m):
    p = (2 ** i) - 1
    parity_sum = sum(hamming[k] for k in range(len(hamming)) if (k + 1) & (p + 1) and hamming[k] is not None)
    hamming[p] = parity_sum % 2 if parity == "even" else (parity_sum + 1) % 2

print("Generated Hamming Code:", ''.join(map(str, hamming)))

# Input transmitted code
transmitted = list(map(int, input("Enter the transmitted Hamming code: ")))
error_pos = 0

# Detect errors
for i in range(m):
    p = (2 ** i) - 1
    parity_sum = sum(transmitted[k] for k in range(len(transmitted)) if (k + 1) & (p + 1))
    if parity_sum % 2 != (0 if parity == "even" else 1):
        error_pos += (2 ** i)

# Correct the error if any
if error_pos:
    print("Error detected at position:", error_pos)
    transmitted[error_pos - 1] ^= 1  # Flip the erroneous bit
    print("Corrected Hamming Code:", ''.join(map(str, transmitted)))
else:
    print("No errors detected. Hamming Code is correct.")
