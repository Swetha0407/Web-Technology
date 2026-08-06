# Technical Note: University Event Registration Portal

**Course:** ITA02 – Web Technology (Unit II)
**Project:** Responsive University Event Registration Portal
**Folder Structure:**
```
CO2_SBA/
├── index.html
├── style.css
└── images/
    ├── hero.jpg
    ├── tech.jpg
    ├── cultural.jpg
    ├── placement.jpg
    └── sports.jpg
```

## 1. CSS Methods Used
The assignment required the demonstration of three CSS application methods:

*   **Inline CSS:** Used exclusively on the submit button within the registration form (`<button type="submit" style="background-color: #1a365d; ...">`). This satisfies the requirement while keeping inline styles to a minimum as they are not maintainable.
*   **Internal CSS:** Applied specifically to the hero section paragraphs (`.hero p`) within the `<style>` block in the document `<head>`. This satisfies the requirement for isolating specific section styles.
*   **External CSS:** The primary design, layout, typography, and responsive rules are contained in `style.css`. This is the most suitable method for a multi-page website because it allows a single file to control the appearance of all pages, ensuring consistency, reducing code duplication, and enabling faster page loads through browser caching.

## 2. Selectors and Core Syntax
The stylesheet utilizes various selector types to target elements accurately:

| Selector Type | Example Used | Purpose |
| :--- | :--- | :--- |
| **Element** | `body` | Base styling for HTML elements |
| **Group** | `h1, h2, h3` | Styling multiple elements with shared properties |
| **Class** | `.card`, `.reg-btn` | Styling reusable components |
| **ID** | `#register`, `#card-tech` | Targeting unique elements |
| **Descendant** | `.card .card-img` | Targeting elements within a container |
| **Child** | `nav.main-nav > ul > li > a` | Targeting direct children |
| **Attribute** | `input[type="email"]` | Targeting inputs by type |
| **Pseudo-class** | `:hover`, `:focus` | Interactive states for buttons and links |
| **Pseudo-element** | `.card h3::after` | Creating visual decorative elements |

## 3. CSS Box Model Calculation
The CSS box model dictates how element dimensions are calculated.

**Selected Element:** `.card` (Specifically `#card-tech`)

**Default `content-box` Model Calculation:**
Under the default CSS model, the total horizontal width is the sum of content, padding, borders, and margins.
*   Content width: `250px`
*   Left/Right Padding: `20px + 20px = 40px`
*   Left/Right Border: `2px + 2px = 4px`
*   Left/Right Margin: `20px + 20px = 40px`
*   **Total Horizontal Space** = 250px + 40px + 4px + 40px = **334px**

**`border-box` Model Calculation:**
If `box-sizing: border-box;` were applied to the card, the padding and borders would be included within the specified width.
*   Specified width: `250px`
*   Left/Right Margin: `20px + 20px = 40px`
*   **Total Horizontal Space** = 250px + 40px = **290px**
*(Note: The card itself would remain 250px wide, but it would take up less total horizontal space in the flow).*

## 4. Layout and Normal Flow
*   **Layout Method:** Flexbox is used for the event catalogue (`.card-container`) with `display: flex; flex-wrap: wrap; justify-content: center;`. This ensures cards wrap to the next line when there isn't enough space, creating a responsive grid that turns into a single column on mobile. Flexbox is also used for the header navigation and card footers to align items horizontally.
*   **Normal Flow:** The document structure follows a logical vertical flow (Header -> Hero -> Events -> Form -> Footer), ensuring the page remains understandable without advanced positioning.

## 5. Beyond the Normal Flow (Positioning)
Two distinct positioning techniques are demonstrated:
1.  **Sticky Positioning:** The main header (`header.site-header`) uses `position: sticky; top: 0;` to remain visible at the top of the viewport as the user scrolls. It is assigned a high `z-index` to ensure it overlays other content.
2.  **Fixed Positioning:** A help button (`.help-btn`) uses `position: fixed; bottom: 20px; right: 20px;` to remain permanently visible in the bottom-right corner of the screen regardless of scrolling.
3.  **Absolute Positioning:** Event status badges (`.status-badge`) use `position: absolute;` to overlay specifically on the image area of their parent event cards.

## 6. Other CSS Properties
The design incorporates over eight specific CSS properties:
*   `background-image` / `linear-gradient` (Hero overlay)
*   `border-radius` (Cards, buttons, form inputs)
*   `box-shadow` (Cards, header, buttons)
*   `text-shadow` (Hero heading)
*   `opacity` (Hero subheading)
*   `overflow` (Hidden on event cards to contain rounded corners)
*   `cursor` (Pointer on interactive buttons)
*   `transition` (Smooth hover effects on buttons and cards)
*   `transform` (Scale effect on CTA button hover, lift effect on card hover)
*   `max-width` (Constraining container widths)

## 7. Responsive Design
*   **Media Queries:** A breakpoint at `@media (max-width: 768px)` is used.
    *   Adjusts the header to a column layout.
    *   Changes the card container to `flex-direction: column;`, ensuring cards become a single column on smaller screens.
    *   Stacks the footer columns.
*   **Viewport Meta Tag:** `<meta name="viewport" content="width=device-width, initial-scale=1.0">` is included to ensure proper scaling on mobile devices.
*   **Mobile Testing:** Tested at 375px width, ensuring no horizontal scrolling is required and all text remains readable.

## 8. Testing Evidence and Corrections
*   **Browsers Tested:** Chromium (primary) and Firefox (secondary).
*   **Layout Issue 1 (Desktop):** Initially, the "Open" badges on the event cards were positioned outside the card boundaries.
    *   *Correction:* Added `position: relative;` to the parent `.card` container so the absolutely positioned badges would constrain to the card edges.
*   **Layout Issue 2 (Mobile):** The navigation links were extending outside the viewport on mobile devices, requiring horizontal scrolling.
    *   *Correction:* Added a media query (`max-width: 768px`) that changes the `nav.main-nav ul` flex direction to `column` and sets the links to `width: 100%`, ensuring they stack vertically and fit within the screen width.
