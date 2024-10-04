# Product and Category Management System

## Description
This system is a backend API developed with **Spring Boot** and **MongoDB**. It allows managing **owners**, **categories**, and **products** through CRUD operations (Create, Read, Update, and Delete).

### Features:
1. **Owner Creation**:
    - An owner has the following fields:
        - `name`: Owner's name.
        - `email`: Owner's email.

2. **Category and Product Creation**:
    - An owner can create categories and products.

    - **Category**:
        - `title`: Category title.
        - `description`: Category description.
        - `ownerId`: ID of the owner who created the category.

    - **Product**:
        - `title`: Product title.
        - `description`: Product description.
        - `price`: Product price.
        - `ownerId`: ID of the owner who created the product.
        - `categoryId`: ID of the associated category.

3. **Product and Category Dependency**:
    - The creation of a product depends on the existence of a category.

4. **CRUD**:
    - The system allows performing all CRUD operations for **owners**, **categories**, and **products**.

## Libraries Used

- `spring-boot-starter-data-mongodb`
- `spring-boot-starter-web`
- `spring-boot-starter-validation`
- `spring-boot-devtools`
- `lombok`
- `spring-boot-starter-test`
- `spring-security-test`
- `commons-lang3`
- `validation-api`
