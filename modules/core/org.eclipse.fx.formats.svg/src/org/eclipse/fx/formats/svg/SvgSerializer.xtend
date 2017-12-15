package org.eclipse.fx.formats.svg

import org.eclipse.fx.formats.svg.svg.SvgSvgElement
import java.io.Writer
import org.eclipse.fx.formats.svg.svg.SvgGElement
import org.eclipse.fx.formats.svg.svg.SvgDefsElement
import org.eclipse.fx.formats.svg.svg.SvgRectElement
import org.eclipse.fx.formats.svg.svg.SvgTextElement
import org.eclipse.fx.formats.svg.svg.SvgLinearGradientElement
import org.eclipse.fx.formats.svg.svg.SvgStopElement
import org.eclipse.fx.formats.svg.svg.SvgPathElement
import org.eclipse.fx.formats.svg.svg.SvgImageElement
import org.eclipse.fx.formats.svg.svg.SvgClipPathElement

class SvgSerializer {
	SvgSvgElement e;

	new(SvgSvgElement e) {
		this.e = e;
	}

	def void toSvg(Writer w) {
		w.append(gen)
	}

	def gen() '''
		<?xml version="1.0" standalone="no"?>
		<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">
		<svg width="«e.width»" height="«e.height»" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
			«FOR c : e.children»
				«c.handle»
			«ENDFOR»
		</svg>
	'''

	def dispatch CharSequence handle(SvgGElement e) '''
		<g
			transform="«e.transform»"
			«IF ! e.clip_path.nullOrEmpty && e.clip_path != "none"»clip-path="«e.clip_path»"«ENDIF»
		>
			«FOR c : e.children»
				«handle(c)»
			«ENDFOR»
		</g>
	'''

	def dispatch CharSequence handle(SvgRectElement e) '''
		<rect
			«IF ! e.x.nullOrEmpty»x="«e.x»"«ENDIF»
			«IF ! e.y.nullOrEmpty»y="«e.y»"«ENDIF»
			«IF ! e.rx.nullOrEmpty»rx="«e.rx»"«ENDIF»
			«IF ! e.ry.nullOrEmpty»ry="«e.ry»"«ENDIF»
			width="«e.width»"
			height="«e.height»"
			«IF ! e.fill.nullOrEmpty»fill="«e.fill»"«ENDIF»
			«IF ! e.fill_opacity.nullOrEmpty»fill-opacity="«e.fill_opacity»"«ENDIF»

			«IF ! e.stroke.nullOrEmpty && e.stroke != "none"»stroke="«e.stroke»"«ENDIF»
			«IF ! e.stroke_width.nullOrEmpty»stroke-width="«e.stroke_width»"«ENDIF»
		/>
	'''

	def dispatch CharSequence handle(SvgTextElement e) '''
		<text
			x="«e.x»"
			y="«e.y»"
			fill="«e.fill»">
			«e.textContent»
		</text>
	'''

	def dispatch CharSequence handle(SvgDefsElement e) '''
		<defs>
			«FOR c : e.children»
				«c.handle»
			«ENDFOR»
		</defs>
	'''

	def dispatch CharSequence handle(SvgPathElement e) '''
		<path
			d="«e.d»"
			«IF ! e.fill.nullOrEmpty»fill="«e.fill»"«ENDIF»
		/>
	'''

	def dispatch CharSequence handle(SvgImageElement e) '''
		<image
«««			x="«e.x»"
«««			y="«e.y»"
		/>
	'''

	def dispatch CharSequence handle(SvgLinearGradientElement e) '''
		<linearGradient id="«e.id»"
			x1="«e.x1»"
			y1="«e.y1»"
			x2="«e.x2»"
			y2="«e.y2»">
			«FOR s : e.children.filter(typeof(SvgStopElement))»
				<stop offset="«s.offset»" stop-color="«s.stop_color»" />
			«ENDFOR»
		</linearGradient>
	'''

	def dispatch CharSequence handle(SvgClipPathElement e) '''
		<clipPath id="«e.id»">
			«FOR c : e.children»
				«c.handle»
			«ENDFOR»
		</clipPath>
	'''
}