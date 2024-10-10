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
        contrast: '#FFFEFE',
        themePage: '#EA8373',
        themePageDark: '#CC7264',
        darkBackground: '#4B4846'
      },
      fontFamily: {
        Montserrat: ['Montserrat', 'Montserrat Fallback'],
        lato: ['Lato', 'Lato Fallback']
      },
     
      gridTemplateColumns: {
        'home': '250px 1fr',
        'gridGraficts': '2fr 1fr',
      },

      gridTemplateRows: {
        'graficsPanel': '350px 1fr',
      },
    },
  },
  plugins: [],
}
