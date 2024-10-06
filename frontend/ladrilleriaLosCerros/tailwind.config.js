/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        background: '#F5F7FF',
        contrast: '#FFFEFE'
      },
      fontFamily: {
        Montserrat: ['Montserrat', 'Montserrat Fallback'],
        lato: ['Lato', 'Lato Fallback']
      },
     
      gridTemplateColumns: {
        'home': '250px 1fr',
        'gridGraficts': '2fr 1fr',
      },
    },
  },
  plugins: [],
}
