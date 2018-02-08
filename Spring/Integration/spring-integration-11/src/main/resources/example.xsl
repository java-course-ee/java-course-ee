<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        version="2.0"
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:javacourse="http://spring-integration.javacourse.edu"
        exclude-result-prefixes="javacourse"
        >

    <xsl:output method="html" indent="yes"/>

    <xsl:template match="javacourse:application">
        <html>
            <head>
                <title>HTML Result</title>
            </head>
            <body>
                <xsl:variable name="age" select="javacourse:age/text()"/>
                <h1>Hello <xsl:value-of select="javacourse:name/text()"/>, your age is <xsl:value-of select="$age"/></h1>
                <xsl:variable name="permission">
                    <xsl:choose>
                        <xsl:when test="$age &gt; 18 or $age = 18">may</xsl:when>
                        <xsl:when test="$age &lt; 18">may not</xsl:when>
                    </xsl:choose>
                </xsl:variable>
                <h3>You <xsl:value-of select="$permission"/> drink C2H5OH</h3>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>