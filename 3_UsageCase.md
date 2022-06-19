## Usage Case
How software will be used

### 3 Types of Actors
1. Primary Users
2. Supporting actors - external computers/systems/people that support the system
3. Offstage actors

## Scenario
Each actor will have numerous scenarios while interacting with the software. Can result in success or failure.

### Format (Of Usage Case)
- Brief - a paragraph that describes a main successful scenario
- Casual - multi-paragraph that covers many scenarios
- Full dress - list every step in variation written out in detail
    - cover the most important 10% of the system up front
    - most common - Alistair Cockburn format

### Example
- Use Case: Provide ATM user with money from checking account

- Scope: ATM Software Application

- Level: User Goal

- Primary Actor: Bank Customer

- Stake Holders and Interests: (All actors involved and their role)

1. Bank Customer
    a. Access to all the funds in both their savings and checking
    b. Deposit Checks
    c. Check their balance while making sure their money is safe
    d. Receive a receipt

2. ATM
    a. Provide funds available to customers
    b. Automatically update fund changes immediately
    c. Protect the bank and customers from false cards or PINs

3. Bank Home Office Computer
    a. Provide accurate account funds information
    b. Update immediately when a transaction occurs system wide

4. Fraud Department
    a. If sent card information, they will verify if a card is stolen

- Preconditions
    a. A valid card is entered
    b. A valid PIN is entered that matches with the card

- Postconditions
    a. Customer is happy with the transaction
    b. The transaction is disseminated to all bank systems
    c. A photo of the customer is taken
    d. Receipt is generated
    e. Card is provided back to the customer

- Main Success Scenario
1. The ATM displays a message on screen identifying itself to customers
2. The customer inserts their card
3. The ATM verifies the legitimacy of the card


- Extensions

*a. At any time if the ATM runs out of funds
    1. Display a closed message
    2. Shutdown the message
    3. Send a message that a technician needs to fill the ATM with funds

*b. At any time if the ATM runs out of receipt paper
    1. Display a closed message
    2. Shutdown the message
    3. Send a message that a technician needs to fill the ATM with paper

3a. The card is from another bank
    1. Connect to the other bank to verify funds
        a. The other bank isn't reachable
            1. Inform the customer that a transaction can't be made
            2. Provide the customer with their card
            3. End transaction
            4. Provide the customer with a receipt
        b. The other bank is reachable
            1. If the customer must pay a fee, inform them of that
                i. Receive verification that the customer understands any fees
                    1. Add the fee as part of the transaction if the customer allows
                    2. If the customer declines, record that and provide the customer with their card and receipt

Special Requirements

1. The text must be readable by color blind people
2. The text must be readable by people who speak other languages


Data Variations List

1. All data uses 256-bit AES encryption

Frequency Occurrence
- Could be constantly

Miscellaneous

1. Is there anything we can do to improve user experience for the blind?
2. Can polarized screens help improve security?

